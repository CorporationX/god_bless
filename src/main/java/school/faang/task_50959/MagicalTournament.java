package school.faang.task_50959;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 5, 100);
        Task task2 = new Task("Yule Ball Preparations", 2, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error: " + exception.getMessage());
            } else {
                try {
                    int hogwartsPoints = hogwartsTask.get().getTotalPoints();
                    int beauxbatonsPoints = beauxbatonsTask.get().getTotalPoints();

                    System.out.println("Hogwarts total points: " + hogwartsPoints);
                    System.out.println("Beauxbatons total points: " + beauxbatonsPoints);

                    if (hogwartsPoints > beauxbatonsPoints) {
                        System.out.println("Hogwarts wins!");
                    } else if (hogwartsPoints < beauxbatonsPoints) {
                        System.out.println("Beauxbatons wins!");
                    } else {
                        System.out.println("It's a draw!");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        allTasks.join();
        tournament.shutdownExecutor();
    }
}
