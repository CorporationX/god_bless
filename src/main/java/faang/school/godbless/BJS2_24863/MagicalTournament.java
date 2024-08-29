package faang.school.godbless.BJS2_24863;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");

        hogwarts.addStudent(student1);
        hogwarts.addStudent(student2);
        hogwarts.addStudent(student3);

        Student student4 = new Student("Student4");
        Student student5 = new Student("Student5");
        Student student6 = new Student("Student6");

        beauxbatons.addStudent(student4);
        beauxbatons.addStudent(student5);
        beauxbatons.addStudent(student6);

        Task task1 = new Task("Task1", 10, 100);
        Task task2 = new Task("Task1", 14, 150);


        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                tournament.startTask(hogwarts, task1),
                tournament.startTask(beauxbatons, task2)
        );

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is "
                        + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is "
                        + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();

    }
}
