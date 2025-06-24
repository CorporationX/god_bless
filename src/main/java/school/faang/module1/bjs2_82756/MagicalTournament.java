package school.faang.module1.bjs2_82756;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class MagicalTournament {

    private static final int TIMEOUT = 10;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Tournament tournament = new Tournament(executorService);
        School hogwarts = new School("Hogwarts", List.of(
                new Student("Harry", 5),
                new Student("Hermione", 5),
                new Student("Ron", 5),
                new Student("Neville", 5)
        ));

        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("Fleur", 6),
                new Student("Gabrielle", 4)
        ));

        Task task1 = new Task("Triwizard Tournament", 10, 120);
        Task task2 = new Task("Yule Ball Preparations", 5, 60);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> Stream.of(hogwarts, beauxbatons)
                        .max(Comparator.comparingInt(School::getTotalPoints))
                        .ifPresentOrElse(
                                winner -> log.info("Победитель: {} с {} очками",
                                        winner.getName(), winner.getTotalPoints()),
                                () -> log.warn("Победитель турнира не определён")
                        ))
                .join();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершились вовремя");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван во время ожидания завершения", e);
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        log.info("Все задачи завершены");
    }
}