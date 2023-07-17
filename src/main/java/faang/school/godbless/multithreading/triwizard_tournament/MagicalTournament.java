package faang.school.godbless.multithreading.triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School(
                "Hogwarts",
                List.of(
                        new Student("Harry Potter", 14, 20),
                        new Student("Ron Weasley", 14, 15),
                        new Student("Hermione Granger", 14, 30)
                )
        );
        School beauxbatons = new School(
                "Beauxbatons",
                List.of(
                        new Student("Fleur Delacour", 17, 35),
                        new Student("Gabrielle Delacour", 11, 20)
                )
        );

        Task task1 = new Task("Task 1", 1000, 100);
        Task task2 = new Task("Task 2", 1500, 150);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).thenRun(() -> {
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
