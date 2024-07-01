package TriwizardTournament;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = createHogwarts();
        School beauxbatons = createBeauxbatons();
        Task taskHogwarts = new Task("FirstQuest", 2, 10);
        Task taskBeauxbatons = new Task("FirstQuest", 3, 15);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, taskHogwarts);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, taskBeauxbatons);

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

    public static School createHogwarts() {
        return new School("Hogwards", Arrays.asList(
                new Student("Harry", 18, 0),
                new Student("Ron", 19, 0)));
    }

    public static School createBeauxbatons() {
        return new School("Beauxbatons", Arrays.asList(
                new Student("Gabrielle", 18, 0),
                new Student("Nicolas", 20, 0)));
    }
}
