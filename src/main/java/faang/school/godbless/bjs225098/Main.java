package faang.school.godbless.bjs225098;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsSchool1 = new ArrayList<>(List.of(
                new Student("student1", 2024, 0),
                new Student("student2", 2024, 0),
                new Student("student3", 2024, 0)
        ));
        List<Student> studentsSchool2 = new ArrayList<>(List.of(
                new Student("student4", 2024, 0),
                new Student("student5", 2024, 0),
                new Student("student6", 2024, 0)
        ));

        Task task1 = new Task("task1", 50);
        Task task2 = new Task("task2", 50);

        School school1 = new School("school1", studentsSchool1);
        School school2 = new School("school2", studentsSchool2);

        Tournament tournament = new Tournament();

        CompletableFuture<School> school1Task = tournament.startTask(school1, task1);
        CompletableFuture<School> school2Task = tournament.startTask(school2, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(school1Task, school2Task);
        allTasks.thenRun(() -> {
                    if (school1.getTotalPoints() > school2.getTotalPoints()) {
                        System.out.println("The winner of the magical tournament is "
                                + school1.getName() + " with " + school1.getTotalPoints() + " points."
                        );
                        System.out.println(school2.getName() + ": " + school2.getTotalPoints());
                    } else if (school2.getTotalPoints() > school1.getTotalPoints()) {
                        System.out.println("The winner of the magical tournament is "
                                + school2.getName() + " with " + school2.getTotalPoints() + " points.");
                        System.out.println(school1.getName() + ": " + school1.getTotalPoints());
                    } else {
                        System.out.println("The magical tournament ended in a tie! " + school1.getTotalPoints() + " - " + school2.getTotalPoints());

                    }
                }
        ).join();
    }
}