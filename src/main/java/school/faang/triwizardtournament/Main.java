package school.faang.triwizardtournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Fighting the Dragon", "Easy", 50);
        Task task2 = new Task("Rescuing a prisoner underwater", "Medium", 100);
        Task task3 = new Task("Passing the Labyrinth ", "Hard", 150);

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> hogwartsTask3 = tournament.startTask(hogwarts, task3);
        CompletableFuture<School> beauxbatonsTask3 = tournament.startTask(beauxbatons, task3);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask1, beauxbatonsTask1,
                hogwartsTask2, beauxbatonsTask2, hogwartsTask3, beauxbatonsTask3);
        allTasks.thenRun(() -> {
            int hogwartPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();
            if (hogwartPoints > beauxbatonsPoints) {
                System.out.println("The " + hogwarts.getName() + " team won with a total of " + hogwartPoints +
                        " points! Congratulations to the winner!");
            } else {
                System.out.println("The " + beauxbatons.getName() + " team won with a total of " + hogwartPoints +
                        " points! Congratulations to the winner!");
            }
        });
        tournament.shutdown();
    }
}
