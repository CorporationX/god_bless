package faang.school.godbless.fourthsprint.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = TournamentSetup.createSchool("Hogwarts", TournamentSetup.createHogwartsTeam());
        School beauxbatons = TournamentSetup.createSchool("Beauxbatons", TournamentSetup.createBeauxbatonsTeam());
        School durmstrang = TournamentSetup.createSchool("Durmstrang", TournamentSetup.createDurmstrangTeam());

        Task task1 = new Task("Defeat the Dragon", 5, 100);
        Task task2 = new Task("Rescue from the Lake", 3, 80);
        Task task3 = new Task("Maze Challenge", 4, 90);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, task3);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, durmstrangTask);

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();
            int durmstrangPoints = durmstrang.getTotalPoints();

            if (hogwartsPoints > beauxbatonsPoints && hogwartsPoints > durmstrangPoints) {
                System.out.println("The winner of the magical tournament is " +
                        hogwarts.getName() + " with " + hogwartsPoints + " points.");
            } else if (beauxbatonsPoints > hogwartsPoints && beauxbatonsPoints > durmstrangPoints) {
                System.out.println("The winner of the magical tournament is " +
                        beauxbatons.getName() + " with " + beauxbatonsPoints + " points.");
            } else if (durmstrangPoints > hogwartsPoints && durmstrangPoints > beauxbatonsPoints) {
                System.out.println("The winner of the magical tournament is " +
                        durmstrang.getName() + " with " + durmstrangPoints + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
