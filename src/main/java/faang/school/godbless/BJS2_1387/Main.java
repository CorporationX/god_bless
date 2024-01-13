package faang.school.godbless.BJS2_1387;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = Arrays.asList(
                new Student("Harry", 12),
                new Student("Hermione", 13),
                new Student("Ron", 13)
        );

        List<Student> beauxbatonsStudents = Arrays.asList(
                new Student("Fleur", 14),
                new Student("Gabrielle", 15),
                new Student("Louis", 16)
        );

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("Dragons", 5, 200);
        Task task2 = new Task("Maze", 4, 150);

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
