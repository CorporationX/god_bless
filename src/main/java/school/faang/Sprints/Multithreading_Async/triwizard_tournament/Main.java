package school.faang.Sprints.Multithreading_Async.triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
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

        Task task1 = new Task("Triwizard Tournament", 10, 50);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
                    int resultHogwarts = hogwarts.getTotalPoints();
                    int resultBeauxbatons = beauxbatons.getTotalPoints();
                    if (resultHogwarts > resultBeauxbatons) {
                        System.out.println("Hogwarts WIN!!!");
                    } else if (resultHogwarts < resultBeauxbatons) {
                        System.out.println("Beauxbatons WIN!!!");
                    } else {
                        System.out.println("FINAL BATTLE!!!!!");
                    }
                })
                .join();
    }
}