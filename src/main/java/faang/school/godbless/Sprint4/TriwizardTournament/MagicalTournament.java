package faang.school.godbless.Sprint4.TriwizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) throws InterruptedException {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий
        School hogwarts = new School("Hogwarts", List.of(new Student("Harry Potter", 10, 5), new Student("Random Dude", 40, 0)));
        School beauxbatons = new School("Beauxbatons", List.of(new Student("Germiona", 10, 5)));
        Task task1 = new Task("Task 1", 5, 3);

        // Запуск заданий
        CompletableFuture<CompletableFuture<School>> hogwartsTask = CompletableFuture.supplyAsync(() -> {
            try {
                return tournament.startTask(hogwarts, task1);
            } catch (InterruptedException e) {
                System.out.println(e);
                return null;
            }
        });
        CompletableFuture<CompletableFuture<School>> beauxbatonsTask = CompletableFuture.supplyAsync(() -> {
            try {
                return tournament.startTask(beauxbatons, task1);
            } catch (InterruptedException e) {
                System.out.println(e);
                return null;
            }
        });

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(beauxbatonsTask, hogwartsTask);
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
