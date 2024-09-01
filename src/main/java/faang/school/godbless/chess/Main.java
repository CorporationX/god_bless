package faang.school.godbless.chess;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwardsStudens = List.of(
                new Student("H_student1", 1),
                new Student("H_student2", 1),
                new Student("H_student3", 1),
                new Student("H_student4", 1)
        );

        List<Student> beauxbatonsStudens = List.of(
                new Student("B_student1", 3),
                new Student("B_student2", 3),
                new Student("B_student3", 3),
                new Student("B_student4", 3)
        );

        School hogwarts = new School("Hogwards", hogwardsStudens);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudens);

        Task task1 = new Task("Win in autochess", 5, 50);
        Task task2 = new Task("Defeat the Lord WDM", 10, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("Hogwards is loosing. Points pouring from Dumbledore ASAP");
                hogwarts.team().forEach(student -> student.setPoints(student.getPoints() + 1000));
            }
            System.out.println("The winner of the magical tournament is " + hogwarts.name() +
                    " with " + hogwarts.getTotalPoints() + " points");

        }).join();
    }
}
