package school.faang.bjs2_92878;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, new AtomicInteger(0)),
                new Student("Hermione", 5, new AtomicInteger(0)));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, new AtomicInteger(0)),
                new Student("Gabrielle", 6, new AtomicInteger(0)));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task firstTask = new Task("Triwizard Tournament", Difficulty.HARD);
        Task secondTask = new Task("Yule Ball Preparations", Difficulty.MEDIUM);

        CompletableFuture<School> hogwartsTask = Tournament.startTask(hogwarts, firstTask);
        CompletableFuture<School> beauxbatonsTask = Tournament.startTask(beauxbatons, secondTask);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.printf("%s лучшая команда!", hogwarts.getName());
            } else {
                System.out.printf("%s лучшая команда", beauxbatons.getName());
            }
        });

        Tournament.EXECUTOR.shutdown();
        try {
            if (!Tournament.EXECUTOR.awaitTermination(1, TimeUnit.MINUTES)) {
                Tournament.EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Tournament.EXECUTOR.shutdownNow();
        }
    }
}
