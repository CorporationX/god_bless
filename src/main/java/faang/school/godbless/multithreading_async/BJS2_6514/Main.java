package faang.school.godbless.multithreading_async.BJS2_6514;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", List.of(
                new Student("Harry", 1, 0),
                new Student("Ron", 1, 0),
                new Student("Hermiona", 1, 0)
        ));
        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("Ivan", 1, 0),
                new Student("Roman", 1, 0),
                new Student("Boris", 1, 0)
        ));

        Task task1 = new Task("Task1", 3, 10);
        Task task2 = new Task("Task2", 2, 8);

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
