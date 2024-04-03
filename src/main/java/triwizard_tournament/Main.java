package triwizard_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", studentsHogwarts());
        School faangSchool = new School("Faang School", studentsFaangSchool());

        Task dragon = new Task("Dragon", 5, 6);
        Task swimming = new Task("Swimming", 6, 8);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, dragon);
        CompletableFuture<School> faangSchoolTask = tournament.startTask(faangSchool, swimming);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, faangSchoolTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > faangSchool.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (faangSchool.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + faangSchool.getName() + " with " + faangSchool.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static List<Student> studentsHogwarts() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry Potter", 15, 0));
        students.add(new Student("Ron Weasley", 15, 0));
        students.add(new Student("Hermione Granger", 15, 0));
        return students;
    }

    private static List<Student> studentsFaangSchool() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vlad", 18, 0));
        students.add(new Student("Irina", 18, 0));
        students.add(new Student("Inna", 19, 0));
        return students;
    }
}