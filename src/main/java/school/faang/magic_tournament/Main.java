package school.faang.magic_tournament;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = Arrays.asList(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = Arrays.asList(new Student("Fleur", 6), new Student("Gabrielle", 6));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 70);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        System.out.println(hogwarts.getName() + " wins the tournament with " + hogwarts.getTotalPoints());
                    } else {
                        System.out.println(beauxbatons.getName() + " wins the tournament!");
                    }
                })
                .join();
    }
}
