package faang.school.godbless.ThreeWizardsTournament;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Task task1 = new Task("task1", 3, 4);
        Task task2 = new Task("task1", 2, 5);
        School hogwarts = new School("hogwarts");
        hogwarts.getTeam().add(new Student("oleg", 4));
        hogwarts.getTeam().add(new Student("valera", 4));

        School beauxbatons = new School("beauxbatons");
        beauxbatons.getTeam().add(new Student("anya", 4));
        beauxbatons.getTeam().add(new Student("barer", 4));


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
