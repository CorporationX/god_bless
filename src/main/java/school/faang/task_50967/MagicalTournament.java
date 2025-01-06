package school.faang.task_50967;

import java.util.*;
import java.util.concurrent.*;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            CompletableFuture<Integer> hogwartsPointsFeature = hogwartsTask
                    .thenApply(School::getTotalPoints);
            CompletableFuture<Integer> beauxbatonsPointsFeature = beauxbatonsTask
                    .thenApply(School::getTotalPoints);

            hogwartsPointsFeature.thenAccept(hogwartsPoints ->
                    beauxbatonsPointsFeature.thenAccept(beauxbatonsPoints -> {
                        if (hogwartsPoints > beauxbatonsPoints) {
                            System.out.println(hogwarts.getName() + " wins the tournament!");
                        } else if (hogwartsPoints < beauxbatonsPoints) {
                            System.out.println(beauxbatons.getName() + " wins the tournament!");
                        } else {
                            System.out.println("It's a tie!");
                        }
                    })
            );
        });

        allTasks.join();
    }
}