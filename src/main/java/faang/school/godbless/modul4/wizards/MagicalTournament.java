package faang.school.godbless.modul4.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student harryPotter = new Student("Harry Potter", 5, 0);
        School hogwarts = new School("Hogwarts", new ArrayList<>(List.of(harryPotter)));
        Task task1 = new Task("Task1", 5, 500);
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);

        Student fleurDelacour = new Student("Fleur Delacour", 5, 0);
        School beauxbatons = new School("Beauxbatons", new ArrayList<>(List.of(fleurDelacour)));
        Task task2 = new Task("Task2", 4, 400);
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
