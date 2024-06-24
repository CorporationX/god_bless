package faang.school.godbless.theTriwizardTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> studentsHogwarts = new ArrayList<>();
        studentsHogwarts.add(new Student("A", 1, 3));
        studentsHogwarts.add(new Student("B", 3, 3));
        studentsHogwarts.add(new Student("C", 2, 1));
        studentsHogwarts.add(new Student("D", 1, 5));

        School hogwarts = new School("hogwarts", studentsHogwarts);

        List<Student> studentsBeauxbatons = new ArrayList<>();
        studentsBeauxbatons.add(new Student("A", 1, 3));
        studentsBeauxbatons.add(new Student("B", 3, 1));
        studentsBeauxbatons.add(new Student("C", 2, 1));
        studentsBeauxbatons.add(new Student("D", 1, 2));

        School beauxbatons = new School("beauxbatons", studentsBeauxbatons);
        System.out.println(hogwarts.getTotalPoints());
        System.out.println(beauxbatons.getTotalPoints());

        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, new Task("2", 10, 20));
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, new Task("1", 5, 10));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
                System.out.println(hogwarts.getTotalPoints());

            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
                System.out.println(beauxbatons.getTotalPoints());

            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}