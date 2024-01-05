package faang.school.godbless.TriwizardTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School("hogwarts", new ArrayList<>(List.of(
                new Student("Harry Potter", 15, 0),
                new Student("Cedric Diggory", 17, 0),
                new Student("Aurelius Dumbledore", 92, 0))));
        School beauxbatons = new School("beauxbatons", new ArrayList<>(List.of(
                new Student("Fleur Delacour", 17, 0),
                new Student("Viktor Krum", 18, 0),
                new Student("Nicolas Flamel", 115, 0))));

        Task task1 = new Task("Fight with a dragon", 2, 10);
        Task task2 = new Task("Time Travel", 3, 10);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            System.out.println(hogwarts.getName() + " " + hogwarts.getTotalPoints() + " очков");
            System.out.println(beauxbatons.getName() + " " + beauxbatons.getTotalPoints() + " очков");
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
