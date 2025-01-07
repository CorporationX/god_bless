package school.faang.moduleone.sprintfour.task_43582;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MagicalTournament {
    private static final int TEAM_COUNTS = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(TEAM_COUNTS);
        Tournament tournament = new Tournament(executor);

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    System.out.println("[H] " + hogwarts.getTotalPoints() + ": [B]" + beauxbatons.getTotalPoints());
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        System.out.println(hogwarts.getName() + " wins the tournament!");
                    } else if (hogwarts.getTotalPoints() == beauxbatons.getTotalPoints()) {
                        System.out.println("Drawn game!");
                    } else {
                        System.out.println(beauxbatons.getName() + " wins the tournament!");
                    }
                });

        allTasks.join();

        shutdownGracefully(executor);
    }

    private static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.error("часть потоков не завершили задачи в отведенное время. Останавливаем принудительно");
                executor.shutdownNow();
            }
            log.info("Все потоки завершились успешно");
        } catch (InterruptedException e) {
            log.error("Корректное завершение потоков было прервано. Останавливаем принудительно");
            executor.shutdownNow();
        }
    }
}
