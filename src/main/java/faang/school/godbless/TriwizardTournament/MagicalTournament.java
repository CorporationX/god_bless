package faang.school.godbless.TriwizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", List.of(
                new Student("HogwartsStudent1", 3, 100),
                new Student("HogwartsStudent2", 4, 20),
                new Student("HogwartsStudent3", 2, 80),
                new Student("HogwartsStudent4", 3, 65),
                new Student("HogwartsStudent5", 4, 10)
        ));
        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("BeauxbatonsStudent1", 3, 50),
                new Student("BeauxbatonsStudent2", 3, 80),
                new Student("BeauxbatonsStudent3", 2, 100),
                new Student("BeauxbatonsStudent4", 4, 50),
                new Student("BeauxbatonsStudent5", 3, 115)
        ));
        Task task1 = new Task("Task1", 3, 20);
        Task task2 = new Task("Task2", 2, 15);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
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
