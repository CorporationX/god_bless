package school.faang.threemagicians;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 3), new Student("Hermione", 5, 2));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 1), new Student("Gabrielle", 6, 1));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).thenRun(() -> {
            School hogwartsResult = hogwartsTask.join();
            School beauxbatonsResult = beauxbatonsTask.join();

            if (hogwartsResult.getTotalPoints() > beauxbatonsResult.getTotalPoints()) {
                System.out.println("Победитель: " + hogwartsResult.getName());
            } else if (hogwartsResult.getTotalPoints() < beauxbatonsResult.getTotalPoints()) {
                System.out.println("Победитель: " + beauxbatonsResult.getName());
            } else {
                System.out.println("Ничья!");
            }
        }).join();
    }
}
