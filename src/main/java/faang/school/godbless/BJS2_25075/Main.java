package faang.school.godbless.BJS2_25075;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов для Хогвартса
        Student harry = new Student("Harry Potter", 4, 200);
        Student hermione = new Student("Hermione Granger", 4, 300);
        Student ron = new Student("Ron Weasley", 4, 150);

        // Создание студентов для Шармбатон
        Student fleur = new Student("Fleur Delacour", 4, 220);
        Student gabrielle = new Student("Gabrielle Delacour", 2, 180);
        Student vincent = new Student("Vincent Crabe", 4, 160);

        // Создание школ
        School hogwarts = new School("Hogwarts", Arrays.asList(harry, hermione, ron));
        School beauxbatons = new School("Beauxbatons", Arrays.asList(fleur, gabrielle, vincent));

        // Создание заданий
        Task task1 = new Task("Defeat the Basilisk", 5, 100);
        Task task2 = new Task("Find the Philosopher's Stone", 4, 80);

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
