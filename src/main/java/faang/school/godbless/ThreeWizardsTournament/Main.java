package faang.school.godbless.ThreeWizardsTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> students = getStudents();
        School hogwarts = new School("Hogwarts", students.subList(0, 5));
        School beauxbatons = new School("Beauxbatons", students.subList(5, 10));

        Task task1 = new Task("Find the Philosopher's Stone", 5, 100);
        Task task2 = new Task("Save Sirius Black", 7, 200);

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

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry Potter", 5, 80));
        students.add(new Student("Ron Weasley", 5, 75));
        students.add(new Student("Hermione Granger", 5, 90));
        students.add(new Student("Neville Longbottom", 5, 60));
        students.add(new Student("Draco Malfoy", 5, 50));
        students.add(new Student("Luna Lovegood", 5, 30));
        students.add(new Student("Fred Weasley", 6, 85));
        students.add(new Student("George Weasley", 6, 85));
        students.add(new Student("Ginny Weasley", 6, 70));
        students.add(new Student("Seamus Finnigan", 6, 65));
        return students;
    }
}
