package faang.school.godbless.async.wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        var hogwartsStudents = List.of(
                new Student("Harry", 2005, 0),
                new Student("Ron", 2005, 0),
                new Student("Hermione", 2005, 0)
        );
        var beauxbatonsStudents = List.of(
                new Student("Pete", 2005, 0),
                new Student("Henry", 2005, 0),
                new Student("Noodles", 2005, 0)
        );
        School hogwarts = new School("hogwarts", hogwartsStudents);
        School beauxbatons = new School("beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("task1", 5, 100);
        Task task2 = new Task("task2", 10, 100);

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