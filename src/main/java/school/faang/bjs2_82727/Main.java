package school.faang.bjs2_82727;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final int POOL_AWAIT_TIMEOUT = 20;
    private static ExecutorService fixedPool = Executors.newFixedThreadPool(Runtime.getRuntime()
                                                                                    .availableProcessors());
    private static Tournament tournament = new Tournament(fixedPool);

    public static void main(String[] args) {
        List<Task> tasks = List.of(new Task("Сражение с драконом"),
                                   new Task("Спасение узника"),
                                   new Task("Прохождение Лабиринта"));

        List<Student> hogwartsStudents = List.of(new Student("Harry Potter", 5),
                                                 new Student("Cedric Diggory", 7),
                                                 new Student("Fred Weasley", 6),
                                                 new Student("George Weasley", 6));

        List<Student> durmstrangStudents = List.of(new Student("Viktor Krum", 8),
                                                   new Student("Pieter Talli", 7));

        List<Student> beauxbatonsStudents = List.of(new Student("Fleur Delacour", 7),
                                                    new Student("Celine Castillon", 7));

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School durmstrang = new School("Durmstrang", durmstrangStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);


        List<CompletableFuture<School>> futures = new ArrayList<>();
        for (Task task : tasks) {
            futures.add(tournament.startTask(hogwarts, task));
            futures.add(tournament.startTask(durmstrang, task));
            futures.add(tournament.startTask(beauxbatons, task));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(param -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toSet())
                        .stream()
                        .max(Comparator.comparingInt(School::getTotalPoints))
                        .ifPresentOrElse(school -> log.info("Победитель турнира школа '{}' с кол-ом очков {}",
                                                            school.getName(), school.getTotalPoints()),
                                         () -> log.info("Победитель турнира не определен"))).join();

        fixedPool.shutdown();

        try {
            while (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершены");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            fixedPool.shutdownNow();
        }
        log.info("Все задачи завершены");
    }
}
