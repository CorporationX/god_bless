package the_triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    /**
     * This is the main entry point of the Triwizard Tournament application.
     * <p>
     * It creates two teams of students, Hogwarts and Beauxbatons, and runs
     * two tasks in parallel. The first task is the Triwizard Tournament,
     * which takes 10 seconds and rewards 100 points. The second task is
     * the Yule Ball Preparations, which takes 5 seconds and rewards 50
     * points. After both tasks are completed, the total points of each
     * team are printed to the console.
     * <p>
     * This example demonstrates how to use {@link CompletableFuture} to
     * run tasks concurrently and wait for their results.
     */
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenAccept(result -> {
            System.out.println("Tournament results:");
            System.out.println("Hogwarts: " + hogwarts.getTotalPoints());
            System.out.println("Beauxbatons: " + beauxbatons.getTotalPoints());
        }).join();
    }
}
