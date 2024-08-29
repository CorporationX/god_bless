package faang.school.godbless.BJS2_24912;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student harry = new Student("Harry", 5, 0);
        Student ron = new Student("Ron", 5, 0);
        Student hermione = new Student("Hermoione", 5, 0);

        Student fleur = new Student("Fleur", 5, 0);
        Student gabrielle = new Student("Gabrielle", 5, 0);

        School hogwarts = new School("Hogwarts", Arrays.asList(harry, ron, hermione));
        School beauxbatons = new School("Beauxbatons", Arrays.asList(fleur, gabrielle));

        Task task1 = new Task("Kill voldemort", 10, 100);
        Task task2 = new Task("Obtain Mandracore Grain", 2, 20);


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
