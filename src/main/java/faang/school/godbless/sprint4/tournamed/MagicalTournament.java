package faang.school.godbless.sprint4.tournamed;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", List.of(
                new Student("Harry Potter", 1, 10),
                new Student("Ron Weasley", 2,10),
                new Student("Hermione Granger", 3,15)));

        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("Fred Weasley", 1, 10),
                new Student("George Weasley", 2,15),
                new Student("Rubeus Hagrid", 3,25)));

        Task task1 = new Task("Task 1", 1, 10);
        Task task2 = new Task("Task 2", 2, 15);


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
