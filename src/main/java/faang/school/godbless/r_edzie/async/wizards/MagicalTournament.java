package faang.school.godbless.r_edzie.async.wizards;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        Student harry = new Student("Harry", 2001, 0);
        Student sedrik = new Student("Sedrik", 1999, 0);

        Student viktor = new Student("Viktor", 1999, 0);

        hogwarts.addStudent(harry);
        hogwarts.addStudent(sedrik);
        beauxbatons.addStudent(viktor);

        Task task1 = new Task("1", 12, 100);
        Task task2 = new Task("2", 5, 10);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            System.out.println(hogwarts.getTotalPoints());
            System.out.println(beauxbatons.getTotalPoints());

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