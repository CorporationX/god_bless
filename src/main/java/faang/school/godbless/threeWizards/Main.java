package faang.school.godbless.threeWizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", List.of(new Student("Germiona", 4),
                new Student("Garry", 5), new Student("Ron", 3)));
        School beauxbatons = new School("Beauxbatons", List.of(new Student("John", 2),
                new Student("Mary", 5), new Student("Miles", 3)));
        Task task1 = new Task("Kill the Dragon", 2, 5);
        Task task2 = new Task("Escape from Labyrinth", 4, 10);
        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, List.of(task1, task2));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, List.of(task1, task2));

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
