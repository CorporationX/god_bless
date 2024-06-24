package faang.school.godbless.async.wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School school1 = new School("School 1", List.of(
                new Student("[1] St 1", 10),
                new Student("[1] St 2", 10),
                new Student("[1] St 3", 10)));
        School school2 = new School("School 2", List.of(
                new Student("[2] St 1", 10),
                new Student("[2] St 2", 10),
                new Student("[2] St 3", 10)));
        School school3 = new School("School 3", List.of(
                new Student("[3] St 1", 10),
                new Student("[3] St 2", 10),
                new Student("[3] St 3", 10)));

        Task task1 = new Task("Task 1", 5, 100);
        Task task2 = new Task("Task 2", 15, 120);

        CompletableFuture<School> school1Tasks = tournament.startTask(school1, task1)
                .thenCompose(school -> tournament.startTask(school, task2));
        CompletableFuture<School> school2Tasks = tournament.startTask(school2, task1)
                .thenCompose(school -> tournament.startTask(school, task2));
        CompletableFuture<School> school3Tasks = tournament.startTask(school3, task1)
                .thenCompose(school -> tournament.startTask(school, task2));

        CompletableFuture<Void> alledOf = CompletableFuture.allOf(school1Tasks, school2Tasks, school3Tasks);
        alledOf.thenRun(() -> {
            System.out.printf("%s total points: %s\n", school1.getName(), school1.getTotalPoints());
            System.out.printf("%s total points: %s\n", school2.getName(), school2.getTotalPoints());
            System.out.printf("%s total points: %s\n", school3.getName(), school3.getTotalPoints());
        });

        alledOf.join();
    }
}
