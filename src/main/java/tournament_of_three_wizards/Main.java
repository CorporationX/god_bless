package tournament_of_three_wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Student harry = new Student("Harry Potter", 4);
        Student hermione = new Student("Hermione Granger", 4);
        List<Student> hogwartsTeam = List.of(harry, hermione);
        School hogwarts = new School("Hogwarts", hogwartsTeam);

        Student fleur = new Student("Fleur Delacour", 6);
        Student gabrielle = new Student("Gabrielle Delacour", 4);
        List<Student> beauxbatonsTeam = List.of(fleur, gabrielle);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Task 1", 3, 10);
        Task task2 = new Task("Task 2", 4, 8);

        Tournament tournament = new Tournament();

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
