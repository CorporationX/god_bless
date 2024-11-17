package school.faang.asynchrony.tournament;

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

        hogwartsTask.join();
        beauxbatonsTask.join();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            System.out.println(hogwarts.getName() + " has " + hogwarts.getTotalPoints() + " points.");
            System.out.println(beauxbatons.getName() + " has " + beauxbatons.getTotalPoints() + " points.");

            String winner = hogwarts.getTotalPoints() > beauxbatons.getTotalPoints() ? hogwarts.getName() : beauxbatons.getName();
            System.out.println("And the winner is: " + winner);
        });
    }

}
