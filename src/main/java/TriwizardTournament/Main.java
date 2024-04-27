package TriwizardTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("some_stud", 18, 2));
        students1.add(new Student("some_stud", 18, 2));
        School magicSchool1 = new School("magical_1", students1);

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("some_stud", 18, 3));
        students2.add(new Student("some_stud", 18, 3));
        School magicSchool2 = new School("magical_2", students2);

        Task task1 = new Task("task_1", 10, 20);
        Task task2 = new Task("task_2", 20, 10);

        Tournament tournament = new Tournament();

        CompletableFuture<School> future1 = tournament.startTask(magicSchool1, task1);
        CompletableFuture<School> future2 = tournament.startTask(magicSchool2, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(future1, future2);
        allTasks.thenRun(() -> {
            if (magicSchool1.getTotalPoints() > magicSchool2.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        magicSchool1.getName() + " with " + magicSchool1.getTotalPoints() + " points.");
            } else if (magicSchool2.getTotalPoints() > magicSchool1.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        magicSchool2.getName() + " with " + magicSchool2.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
