package faang.school.multithreadingparallelismthread.thetriwizardtournament;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> studentsHogwarts = Arrays.asList(new Student("Max", 22, 0),
                new Student("Oleg", 18, 0), new Student("Nadia", 32, 0));
        List<Student> studentBeauxbatonss = Arrays.asList(new Student("Max", 35, 0),
                new Student("Oleg", 25, 0), new Student("Nadia", 27, 0));

        School hogwarts = new School("Hogwarts", studentsHogwarts);
        School beauxbatons = new School("Beauxbatons", studentBeauxbatonss);

        Task task1 = new Task("Task1", 3, 350);
        Task task2 = new Task("Task2", 2, 250);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

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

