package school.faang.sprint4.task62550;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final String WINNER_ANNOUNCEMENT = "\nWinner - %s with %d points!";

    public static void main(String[] args) {
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6), new Student("Gabrielle", 6));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        Tournament tournament = new Tournament();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            School hogwartsResult = hogwartsTask.join();
            School beauxbatonsResult = beauxbatonsTask.join();
            int hogwartsPoints = hogwartsResult.getTotalPoints();
            int beauxbatonsPoints = beauxbatonsResult.getTotalPoints();
            if (hogwartsPoints > beauxbatonsPoints) {
                System.out.printf(WINNER_ANNOUNCEMENT, hogwartsResult.getName(), hogwartsPoints);
            } else if (hogwartsPoints < beauxbatonsPoints) {
                System.out.printf(WINNER_ANNOUNCEMENT, beauxbatonsResult.getName(), beauxbatonsPoints);
            } else {
                System.out.printf("Both schools have %d points.", hogwartsPoints);
            }
        }).join();

    }
}
