package faang.school.godbless.triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", List.of(new Student("Ron", 1991),
                new Student("Harry", 1990),
                new Student("Hermione", 1992)));

        School beauxbatons = new School("Beauxbatons", List.of(new Student("Varya", 1996),
                new Student("Anna", 1996),
                new Student("Vlad", 1995)));

        Task task1 = new Task("Task1", 5, 5);
        Task task2 = new Task("Task2", 10, 10);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() +
                        " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() +
                        " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
