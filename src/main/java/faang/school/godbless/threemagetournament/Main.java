package faang.school.godbless.threemagetournament;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("hogwarts");
        School beauxbatons = new School("beauxbatons");

        Task task1 = new Task("123", 4, 10);
        Task task2 = new Task("123", 3, 8);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
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
