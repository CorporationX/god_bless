package faang.school.godbless.BJS2_24785;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student studentOne = new Student("Harry", 4, 0);
        Student studentTwo = new Student("Sedrik", 7, 0);
        School hogwarts = new School("Hogwarts");
        hogwarts.getStudents().add(studentOne);
        hogwarts.getStudents().add(studentTwo);

        Student studentThree = new Student("Fler", 6, 0);
        School beauxbatons = new School("Beauxbatons");
        beauxbatons.getStudents().add(studentThree);

        Task taskOne = new Task("Dragons", 5, 100);
        Task taskTwo = new Task("Lake", 10, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, taskOne);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, taskTwo);

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
