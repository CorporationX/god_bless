package faang.school.godbless.three_wizard;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student student1 = new Student("Harry", 4);
        Student student2 = new Student("Hermione", 4);
        Student student3 = new Student("Ron", 4);

        School hogwarts = new School("hogwarts", Arrays.asList(student1, student2, student3));

        Student student4 = new Student("Chel1", 4);
        Student student5 = new Student("Chel2", 3);
        Student student6 = new Student("Chel3", 4);

        School beauxbatons = new School("beauxbatons", Arrays.asList(student4, student5, student6));

        Task task1 = new Task("Magical Task 1", 3, 7);
        Task task2 = new Task("Magical Task 2", 4, 6);

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
