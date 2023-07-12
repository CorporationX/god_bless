package faang.school.godbless.sprint5.Multithreading_Async.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tournament tournament = new Tournament();

        School hogwarts = getSchoolHogwarts();
        School beauxbatons = getSchoolBeauxbatons();

        Task task1 = new Task("Сражение с драконом", "easy", 11);
        Task task2 = new Task("Спасение узника", "easy", 10);

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
        });

        System.out.println("Done!");
    }

    private static School getSchoolHogwarts() {
        Student HarryPotter = new Student("Harry Potter", 20, 0);
        Student Ron = new Student("Ron", 20, 0);
        List<Student> students = new ArrayList<>();
        students.add(HarryPotter);
        students.add(Ron);
        return new School("Hogwarts", students);
    }

    private static School getSchoolBeauxbatons() {
        Student student1 = new Student("Student1", 22, 0);
        Student student2 = new Student("Student2", 22, 0);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        return new School("Beauxbatons", students);
    }
}
