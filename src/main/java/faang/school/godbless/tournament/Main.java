package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School("Hogwarts",
                List.of(
                        new Student("Andrey", 22, 0),
                        new Student("Denis", 22, 0),
                        new Student("Vlad", 22, 0)
                ));

        School beauxbatons = new School("Beauxbatons",
                List.of(
                        new Student("Nikita", 22, 0),
                        new Student("Anton", 22, 0),
                        new Student("Maxim", 22, 0)
                ));

        Task task1 = new Task("Task 1", 10, 100);
        Task task2 = new Task("Task 2", 5, 100);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        while (!hogwartsTask.isDone() || !beauxbatonsTask.isDone()) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Your bets?");
        }

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() < hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
