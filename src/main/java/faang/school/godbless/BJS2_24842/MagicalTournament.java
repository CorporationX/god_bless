package faang.school.godbless.BJS2_24842;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts", List.of(new Student("Harry", 4, 0), new Student("Hermione", 4, 0), new Student("Cedric", 7, 0)));
        School beauxbatons = new School("Beauxbatons", List.of(new Student("Fleur", 7, 0), new Student("Davet", 7, 0), new Student("Gabrielle", 3, 0)));

        Task task1 = new Task("First task", 8, 110);
        Task task2 = new Task("Second task", 7, 100);

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

        tournament.shutdown();
    }
}
