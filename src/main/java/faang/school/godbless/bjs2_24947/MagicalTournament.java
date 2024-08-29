package faang.school.godbless.bjs2_24947;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        School hogwarts = new School("hogwarts", List.of(
                new Student("Harry", 1),
                new Student("Ron", 1),
                new Student("Hermione", 1)
        ));
        School beauxbatons = new School("beauxbatons", List.of(
                new Student("Gabrielle", 2),
                new Student("Celine", 2)
        ));

        Tournament tournament = new Tournament(2);

        Task task1 = new Task("task1", 2, 2);
        Task task2 = new Task("task2", 3, 3);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture
                .allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> printResult(hogwarts, beauxbatons))
                .thenAccept(v -> tournament.finish())
                .join();
    }

    private static void printResult(School hogwarts, School beauxbatons) {
        var hogwartsPoints = hogwarts.getTotalPoints();
        var beauxbatonsPoints = beauxbatons.getTotalPoints();
        if (hogwartsPoints > beauxbatonsPoints) {
            System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwartsPoints + " points.");
        } else if (beauxbatonsPoints > hogwartsPoints) {
            System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatonsPoints + " points.");
        } else {
            System.out.println("The magical tournament ended in a tie!");
        }
    }
}
