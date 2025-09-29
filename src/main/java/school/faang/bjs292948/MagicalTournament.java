package school.faang.bjs292948;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
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

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
            .thenRun(() -> {
                try {
                    School hogwartsResult = hogwartsTask.get();
                    School beauxbatonsResult = beauxbatonsTask.get();

                    int hogwartsPoints = hogwartsResult.getTotalPoints();
                    int beauxbatonsPoints = beauxbatonsResult.getTotalPoints();

                    System.out.println("Hogwarts Points: " + hogwartsPoints);
                    System.out.println("Beauxbatons Points: " + beauxbatonsPoints);

                    if (hogwartsPoints > beauxbatonsPoints) {
                        System.out.println("Hogwarts wins!");
                    } else if (beauxbatonsPoints > hogwartsPoints) {
                        System.out.println("Beauxbatons wins!");
                    } else {
                        System.out.println("It's a tie!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        allTasks.join();
    }
}

