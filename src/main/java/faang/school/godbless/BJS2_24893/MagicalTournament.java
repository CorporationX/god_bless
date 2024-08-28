package faang.school.godbless.BJS2_24893;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        List<Student> hogwartsStudents = List.of(new Student("Alex", 20, 0),
                new Student("Max", 20, 0));
        for (Student hogwartsStudent : hogwartsStudents) {
            hogwarts.addStudent(hogwartsStudent);
        }

        List<Student> beauxbatonsStudents = List.of(new Student("Elon", 18, 0),
                new Student("John", 19, 0));
        for (Student beauxbatonsStudent : beauxbatonsStudents) {
            beauxbatons.addStudent(beauxbatonsStudent);
        }

        Task task1 = new Task("duel", 5, 10);
        Task task2 = new Task("steal the dragon egg", 10,20);

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
