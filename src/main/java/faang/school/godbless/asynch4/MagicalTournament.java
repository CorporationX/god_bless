package faang.school.godbless.asynch4;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> hogwartsStudent = getHogwartsStudent();
        List<Student> beauxbatonsStudent = getBeauxbatonsStudent();
        School hogwarts = new School("Hogwarts", hogwartsStudent);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudent);
        Task task1 = new Task("Task1", 5, 10);
        Task task2 = new Task("Task2", 3, 5);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        hogwarts.name() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        beauxbatons.name() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static List<Student> getBeauxbatonsStudent() {
        return List.of(new Student("Girl1", 4),
                new Student("Girl2", 4), new Student("Girl3", 4));
    }

    private static List<Student> getHogwartsStudent() {
        return List.of(new Student("Harry", 4),
                new Student("Ron", 4), new Student("Hermione", 4));
    }
}
