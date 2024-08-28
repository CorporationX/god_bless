package triwizard.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("hogwarts", List.of(
            new Student("Garry", 16, 100),
            new Student("Ron", 15, 50),
            new Student("May", 16, 150)
        ));

        School beauxbatons = new School("beauxbatons", List.of(
            new Student("Tom", 18, 200),
            new Student("Sem", 16, 150),
            new Student("Mary", 17, 300)
        ));

        Task task1 = new Task("Task 1", 1, 50);
        Task task2 = new Task("Task 2", 2, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
