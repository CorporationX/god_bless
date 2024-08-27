package faang.school.godbless.threeMags;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("hogwarts", new ArrayList<>(
                List.of(
                        new Student("mike", 12, 1),
                        new Student("kak", 10, 0),
                        new Student("rak", 23, 9),
                        new Student("kek", 120, 50),
                        new Student("lol", 19, 2),
                        new Student("chel", 2, 10)
                )
        ));

        School beauxbatons = new School("beauxbatons", new ArrayList<>(
                List.of(
                        new Student("keke", 1, 0),
                        new Student("lilly", 101, 60),
                        new Student("loop", 23, 15),
                        new Student("limbo", 11, 3),
                        new Student("pip", 15, 3),
                        new Student("pump", 2, 0)
                )
        ));

        Task task1 = new Task("task1", 5, 1);
        Task task2 = new Task("task2", 10, 4);


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
