package school.faang.bjs2_82824;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIME_AWAIT_TERMINATE_S = 5;
    private static final TimeUnit TIME_UNIT_AWAIT_TERMINATE_S = TimeUnit.SECONDS;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("task 1", 10, 100);
        Task task2 = new Task("task 2", 5, 50);
        Task task3 = new Task("task 3", 10, 100);
        Task task4 = new Task("task 4", 5, 50);
        Task task5 = new Task("task 5", 10, 100);
        Task task6 = new Task("task 6", 5, 50);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1, executor);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task2, executor);
        CompletableFuture<School> hogwartsTask3 = tournament.startTask(hogwarts, task3, executor);
        CompletableFuture<School> beauxbatonsTask4 = tournament.startTask(beauxbatons, task4, executor);
        CompletableFuture<School> hogwartsTask5 = tournament.startTask(hogwarts, task5, executor);
        CompletableFuture<School> beauxbatonsTask6 = tournament.startTask(beauxbatons, task6, executor);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                hogwartsTask1,
                beauxbatonsTask2,
                hogwartsTask3,
                beauxbatonsTask4,
                hogwartsTask5,
                beauxbatonsTask6
        );

        allTasks.thenRun(() -> {
            System.out.printf("%s : %s%n", hogwarts.name(), hogwarts.getTotalPoints());
            System.out.printf("%s : %s%n", beauxbatons.name(), beauxbatons.getTotalPoints());
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_AWAIT_TERMINATE_S, TIME_UNIT_AWAIT_TERMINATE_S)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}