package school.faang.task_50736;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Tournament tournament = new Tournament(executorService);

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 80);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        CompletableFuture<Void> tasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        tasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getAllPoints();
            int beauxbatonsPoints = beauxbatons.getAllPoints();
            if (hogwartsPoints > beauxbatonsPoints) {
                log.info("The school {} that scored {} points won", hogwarts.getName(), beauxbatonsPoints);
            } else if (hogwartsPoints == beauxbatonsPoints) {
                log.info("Draw between schools {} and {}", hogwarts.getName(), beauxbatons.getName());
            } else {
                log.info("The school {} that scored {} points won", beauxbatons.getName(), beauxbatonsPoints);
            }
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("All tasks completed successfully");
            } else {
                log.error("The tasks were not completed");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
