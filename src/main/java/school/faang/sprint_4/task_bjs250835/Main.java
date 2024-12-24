package school.faang.sprint_4.task_bjs250835;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUMBER_OF_THREADS = 2;
    public static final long SECONDS_EXECUTOR_TIMEOUT = 20L;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Tournament tournament = new Tournament(executorService);

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            switch (Integer.compare(hogwartsPoints, beauxbatonsPoints)) {
              case 1 -> log.info("{} wins the tournament!", hogwarts.getName());
              case -1 -> log.info("{} wins the tournament!", beauxbatons.getName());
              case 0 -> log.info("Draw in the tournament!");
              default -> throw new IllegalStateException("Unexpected value");
            }
        });
        allTasks.join();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(SECONDS_EXECUTOR_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Executor timeout expired");
                executorService.shutdownNow();
            } else {
                log.info("Executor closed correctly");
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
