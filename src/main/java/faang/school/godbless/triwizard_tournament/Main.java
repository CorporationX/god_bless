package faang.school.godbless.triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student hStudent1 = new Student("Harry", 16);
        Student hStudent2 = new Student("Ron", 16);
        Student hStudent3 = new Student("Neville", 16);

        School hogwarts = new School("Hogwarts");

        hogwarts.addInTeam(hStudent1);
        hogwarts.addInTeam(hStudent2);
        hogwarts.addInTeam(hStudent3);

        Student bStudent1 = new Student("Fleur", 16);
        Student bStudent2 = new Student("Maxim", 16);
        Student bStudent3 = new Student("Menar", 16);

        School beauxbatons = new School("Beauxbatons");

        beauxbatons.addInTeam(bStudent1);
        beauxbatons.addInTeam(bStudent2);
        beauxbatons.addInTeam(bStudent3);

        Task task1 = new Task("Dragon fight", 10, 200);
        Task task2 = new Task("Prisoner Rescue", 8, 150);

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
