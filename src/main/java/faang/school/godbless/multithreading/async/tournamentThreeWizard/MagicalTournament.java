package faang.school.godbless.multithreading.async.tournamentThreeWizard;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий
        School hogwarts = new School("Hogwarts", Arrays.asList(
                new Student("Alice", 1, 50),
                new Student("Bob", 2, 75),
                new Student("Charlie", 3, 60),
                new Student("Diana", 1, 85)));

        School beauxbatons = new School("Beauxbatons", Arrays.asList(
                new Student("Ethan", 2, 90),
                new Student("Fiona", 3, 95),
                new Student("George", 1, 80)));

        Task task1 = new Task("Echoes of the Ancient Forest", 5, 100);
        Task task2 = new Task("Escape from the Shadow Plains", 7, 150);

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

