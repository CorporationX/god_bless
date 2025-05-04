package school.faang.tournamentwizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("St1", 500, 1),
                new Student("St2", 500, 1)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("St2.1", 500, 1),
                new Student("St2.2", 500, 1)
        );

        School hogwarts = new School("hogwarts", hogwartsTeam);
        School beauxbatons = new School("beauxbatons ", beauxbatonsTeam);

        Task task1 = new Task("Task1", 2, 2);
        Task task2 = new Task("Task2", 4, 8);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            School hogwartsResult = hogwartsTask.join();
            School beauxbatonsResult = beauxbatonsTask.join();

            int hogwartsPoints = hogwartsResult.getTotalPoints();
            int beauxbatonsPoints = beauxbatonsResult.getTotalPoints();

            System.out.println(hogwarts.getName() + " points: " + hogwartsPoints);
            System.out.println(beauxbatons.getName() + " points: " + beauxbatonsPoints);

            if (hogwartsPoints > beauxbatonsPoints) {
                System.out.println(hogwarts.getName() + " wins the tournament!");
            } else if (beauxbatonsPoints > hogwartsPoints) {
                System.out.println(beauxbatons.getName() + " wins the tournament!");
            } else {
                System.out.println("The tournament ended in a tie!");
            }
        }).join();
    }
}
