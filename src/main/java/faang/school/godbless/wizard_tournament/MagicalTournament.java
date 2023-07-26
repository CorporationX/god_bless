package faang.school.godbless.wizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> studentList1 = List.of(
                new Student("student1", 1990, 0),
                new Student("student2", 1990, 0),
                new Student("student3", 1990, 0),
                new Student("student4", 1990, 0),
                new Student("student5", 1990, 0)
        );

        List<Student> studentList2 = List.of(
                new Student("student1", 1990, 0),
                new Student("student2", 1990, 0),
                new Student("student3", 1990, 0),
                new Student("student4", 1990, 0),
                new Student("student5", 1990, 0)
        );

        School hogwarts = new School("Hogwarts", studentList1);
        School beauxbatons = new School("Beauxbatons", studentList2);

        Task task1 = new Task("task1", 8, 100);
        Task task2 = new Task("task1", 10, 200);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            System.out.println("result");
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName()
                        + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName()
                        + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        });
    }
}
