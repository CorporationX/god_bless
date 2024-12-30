package school.faang.task_51774;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            try {
                School hogwartsResult = hogwartsTask.get();
                School beauxbatonsResult = beauxbatonsTask.get();

                School winner = hogwartsResult.getTotalPoints() > beauxbatonsResult.getTotalPoints()
                        ? hogwartsResult
                        : beauxbatonsResult;

                System.out.println("The winner is: " + winner.name() + " with total points: "
                        + winner.getTotalPoints());
            } catch (Exception e) {
                System.err.println("Error while determining the winner: " + e.getMessage());
            }
        }).join();
    }
}
