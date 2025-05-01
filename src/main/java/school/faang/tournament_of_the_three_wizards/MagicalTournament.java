package school.faang.tournament_of_the_three_wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 10),
                new Student("Hermione", 5, 10));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 10),
                new Student("Gabrielle", 6, 10));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(hogwarts.getName() + " wins the tournament!");
                System.out.println("Очки команды " + hogwarts.getName() + " = " + hogwarts.getTotalPoints());
                System.out.println("Очки команды " + beauxbatons.getName() + " = " + beauxbatons.getTotalPoints());
                tournament.shutdown();
            }
        });
    }
}
