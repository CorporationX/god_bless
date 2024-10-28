package dima.evseenko.wizard;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", Difficulty.HARD, 100);
        Task task2 = new Task("Yule Ball Preparations", Difficulty.MEDIUM, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenAccept((Void aVoid) -> {
            System.out.printf("Школа %s выполнила %s%n", hogwarts.getName(), task1.getName());
            System.out.printf("Школа %s выполнила %s%n", beauxbatons.getName(), task2.getName());
            System.out.println(hogwarts.getTotalPoints());
            System.out.println(beauxbatons.getTotalPoints());
        });
    }
}
