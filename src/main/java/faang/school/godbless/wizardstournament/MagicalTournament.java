package faang.school.godbless.wizardstournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", getHogwartsStudents());
        School beauxbatons = new School("beauxbatons", getBatonsStudents());
        Task task1 = new Task("First", 5, 10);
        Task task2 = new Task("Second", 7, 10);

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

        tournament.shutdownAndAwaitExecutor(5L);
    }

    private static List<Student> getHogwartsStudents() {
        return List.of(new Student("Alice", 3, 100),
                new Student("Bob", 2, 85),
                new Student("Charlie", 1, 75),
                new Student("David", 4, 95),
                new Student("Eva", 2, 90),
                new Student("Frank", 3, 80),
                new Student("Grace", 1, 110),
                new Student("Henry", 4, 120),
                new Student("Ivy", 2, 88),
                new Student("Jack", 3, 105)
        );
    }

    private static List<Student> getBatonsStudents() {
        return List.of(new Student("Alice", 3, 100),
                new Student("Bob", 2, 85),
                new Student("Charlie", 1, 75),
                new Student("David", 4, 95),
                new Student("Eva", 2, 90),
                new Student("Frank", 3, 80),
                new Student("Grace", 1, 110),
                new Student("Henry", 4, 120),
                new Student("Ivy", 2, 88),
                new Student("John", 3, 105)
        );
    }
}
