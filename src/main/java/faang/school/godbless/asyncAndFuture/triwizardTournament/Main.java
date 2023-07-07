package faang.school.godbless.asyncAndFuture.triwizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = List.of(
                new Student("Harry Potter", 2001, 0),
                new Student("Hermione Granger", 2001, 0),
                new Student("Ronald Weasley", 2001, 0)
        );
        List<Student> beauxbatonsStudents = List.of(
                new Student("Fleur Delacour", 1998, 0),
                new Student("Gabriel Delacour", 2002, 0),
                new Student("Nicolas Flamel", 1600, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);
        Task task1 = new Task("Dragon fight", 5, 100);
        Task task2 = new Task("Prisoner Rescue", 4, 80);

        // Запуск заданий
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

        tournament.shutdown();
    }
}
