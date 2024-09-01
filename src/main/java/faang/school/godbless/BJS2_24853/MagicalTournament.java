package faang.school.godbless.BJS2_24853;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student artem = new Student("Artem", 4);
        Student tomas = new Student("Tomas", 4);
        Student vladislav = new Student("Vladislav", 4);

        Student maxim = new Student("Maxim", 7);
        Student ivan = new Student("Ivan", 6);

        School hogwarts = new School("Hogwarts", Arrays.asList(artem, tomas, vladislav));
        School beauxbatons = new School("Beauxbatons", Arrays.asList(maxim, ivan));

        Task task1 = new Task("Task 1", 4, 99);
        Task task2 = new Task("Task 2", 6, 67);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            if (hogwartsPoints > beauxbatonsPoints) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwartsPoints + " points.");
            } else if (beauxbatonsPoints > hogwartsPoints) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatonsPoints + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
