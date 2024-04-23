package faang.school.godbless.three_wizard;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", List.of(new Student("Harry", 3, 0), new Student("Ron", 3, 0), new Student("Hermione", 3, 0)));
        School beauxbatons = new School("Beauxbatons", List.of(new Student("Jerry", 3, 0), new Student("Mary", 3, 0), new Student("Lane", 3, 0)));

        Task task1 = new Task("Find somethong magical", 3, 300);
        Task task2 = new Task("Find and catch a unicorn", 5, 500);

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

