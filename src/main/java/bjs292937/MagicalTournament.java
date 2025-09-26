package bjs292937;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            School updtdHogwarts = hogwartsTask.join();
            School updtdBeauxbatons = beauxbatonsTask.join();

            int hogwartsResult = updtdHogwarts.getTotalPoints();
            int beauxbatonsResult = updtdBeauxbatons.getTotalPoints();

            if (hogwartsResult > beauxbatonsResult) {
                System.out.println(updtdHogwarts.name() + " wins with " + hogwartsResult + " points!");
            } else if (beauxbatonsResult > hogwartsResult) {
                System.out.println(updtdBeauxbatons.name() + " wins with " + beauxbatonsResult + " points!");
            } else {
                System.out.println("Friendship wins! Both teams have " + hogwartsResult + " points.");
            }
        });
    }
}
