package faang.school.godbless.BJS2_25050;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament(Executors.newFixedThreadPool(2));

        Student harry = new Student("Harry Potter", 2005, 12);
        Student fleur = new Student("Fleur Delacour", 2006, 15);
        Student robert = new Student("Robert Potter", 2005, 12);
        Student sultan = new Student("Sultan Delacour", 2006, 15);

        School hogwarts = new School("Hogwarts", List.of(harry, fleur));
        School beauxbatons = new School("Beauxbatons", List.of(robert, sultan));

        Task task1 = new Task("Defeat the Dragon", Difficulty.MEDIUM, 5);
        Task task2 = new Task("Rescue the Hostage", Difficulty.HARD, 6);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTeamPoints() > beauxbatons.getTeamPoints()) {
                printWinnerSchool(hogwarts);
            } else if (beauxbatons.getTeamPoints() > hogwarts.getTeamPoints()) {
                printWinnerSchool(beauxbatons);
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static void printWinnerSchool(School school) {
        System.out.printf("The winner of the magical tournament is %s with %d points.%n",
                school.getName(),
                school.getTeamPoints());
    }
}
