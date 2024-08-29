package faang.school.godbless.triwizardtournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", getHogwartsTeam());
        School beauxbatons = new School("Beauxbatons", getBeauxbatonsTeam());

        Task task1 = new Task("Snatch a golden egg from a nest guarded by a deadly dragon", 8, 400);
        Task task2 = new Task("Retrieve something valuable from the bottom of the Hogwart's lake", 10, 600);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        tournament.shutdown();

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

    private static List<Student> getHogwartsTeam() {
        return List.of(
                new Student("Harry Potter", 5),
                new Student("Hermione Granger", 5),
                new Student("Ron Weasley", 5));
    }

    private static List<Student> getBeauxbatonsTeam() {
        return List.of(
                new Student("Fleur Delacour", 6),
                new Student("Gabrielle Delacour", 3)
        );
    }
}