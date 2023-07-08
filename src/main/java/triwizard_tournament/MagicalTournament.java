package triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.util.List;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> studentsOfHogwarts = Arrays.asList(
                new Student("Harry Potter", 3,4),
                new Student("Cedric Diggory", 6,6)
        );

        List<Student> studentsOfBeauxbatons = Arrays.asList(
                new Student("Fleur Delacour", 4,6),
                new Student(" Nicolas Flamel", 15,0)
        );


        School hogwarts = new School("Hogwarts", studentsOfHogwarts);
        School beauxbatons = new School("Beauxbatons", studentsOfBeauxbatons);

        Task task1 = new Task("Battle with the dragon", 150,5);
        Task task2 = new Task("Saving a prisoner", 500, 3);

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
