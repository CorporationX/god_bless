package school.faang.task_51699;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("hogwarts", hogwartsTeam);
        School beauxbatons  = new School("beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> task1Result = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> task2Result = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> result = CompletableFuture.allOf(task1Result, task2Result)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        System.out.println("Hogwarts win!");
                    } else {
                        System.out.println("Beauxbatons win!");
                    }
                });
        result.join();
    }
}
