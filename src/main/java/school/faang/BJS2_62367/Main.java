package school.faang.BJS2_62367;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 7, 100);
        Task task2 = new Task("Yule Ball Preparations", 3, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            School schoolHogwarts = hogwartsTask.join();
            School schoolBeauxbatons = beauxbatonsTask.join();

            System.out.println("Hogwarts total points: " + schoolHogwarts.getTotalPoints());
            System.out.println("Beauxbatons total points: " + schoolBeauxbatons.getTotalPoints());

            School winner = schoolHogwarts.getTotalPoints() < schoolBeauxbatons.getTotalPoints()
                    ? schoolBeauxbatons
                    : schoolHogwarts;

            System.out.println("Winning school: %s!!!".formatted(winner.getName()));
        }).exceptionally(throwable -> {
            System.err.println("One or more tasks failed: " + throwable.getMessage());
            return null;
        }).join();
    }
}
