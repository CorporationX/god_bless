package school.faangSprint4.t06;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> hogwartsTeam = Arrays.asList(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0),
                new Student("Ron", 5, 0)
        );

        List<Student> beauxbatonsTeam = Arrays.asList(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0),
                new Student("Jean", 6, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("Magical Creatures Care", 7, 75);

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task3);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task3);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                hogwartsTask1, hogwartsTask2, beauxbatonsTask1, beauxbatonsTask2
        );

        allTasks.thenRun(() -> {
            System.out.println("\nTournament Results:");
            System.out.printf("%s total points: %d%n",
                    hogwarts.name(), hogwarts.getTotalPoints());
            System.out.printf("%s total points: %d%n",
                    beauxbatons.name(), beauxbatons.getTotalPoints());

            String winner = hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()
                    ? hogwarts.name()
                    : beauxbatons.name();

            System.out.printf("%n %s wins the tournament! %n", winner);
        }).join();
    }
}