package faang.school.godbless.BJS2_1340;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> team1 = List.of(
                new Student("Harry", 4, 0),
                new Student("Hermione", 4, 0),
                new Student("Ron", 4, 0)
        );
        List<Student> team2 = List.of(
                new Student("Fleur", 5, 0),
                new Student("Victor", 6, 0),
                new Student("Gabrielle", 4, 0)
        );

        // Создание волшебных школ
        School hogwarts = new School("Hogwarts", team1);
        School beauxbatons = new School("Beauxbatons", team2);

        // Создание заданий
        Task task1 = new Task("Task1", 3, 100);
        Task task2 = new Task("Task2", 5, 150);

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