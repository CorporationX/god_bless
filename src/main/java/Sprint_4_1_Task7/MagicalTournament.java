package Sprint_4_1_Task7;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School("Hogwarts", List.of(new Student[]{
                new Student("Harry Potter", 1, 100),
                new Student("Ron Weasley", 1, 100),
                new Student("Hermione Granger", 1, 100),
        }));
        School beauxbatons = new School("Beauxbatons", List.of(new Student[]{
                new Student("Draco Malfoy", 2, 100),
                new Student("Albus Dumbledore", 2, 100),
                new Student("Severus Snape", 2, 100),
        }));
        Task task1 = new Task("Task 1", 1, 100);
        Task task2 = new Task("Task 2", 2, 100);
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
