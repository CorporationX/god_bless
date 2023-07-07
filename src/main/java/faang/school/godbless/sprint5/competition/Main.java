package faang.school.godbless.sprint5.competition;

import faang.school.godbless.sprint5.competition.classes.School;
import faang.school.godbless.sprint5.competition.classes.Student;
import faang.school.godbless.sprint5.competition.classes.Task;
import faang.school.godbless.sprint5.competition.classes.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", new ArrayList<>(List.of(
                new Student("Harry Potter", 1, 0),
                new Student("Ron Weasley", 1, 0),
                new Student("Hermione Granger", 1, 0),
                new Student("Draco Malfoy", 1, 0)
        )));

        School beauxbatons = new School("Beauxbatons", new ArrayList<>(List.of(
                new Student("Severus Snape", 2, 0),
                new Student("Albus Dumbledore", 2, 0),
                new Student("Sirius Black", 2, 0)
        )));

        Task task1 = new Task("Task 1", 1, 100);
        Task task2 = new Task("Task 2", 2, 200);
        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
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
