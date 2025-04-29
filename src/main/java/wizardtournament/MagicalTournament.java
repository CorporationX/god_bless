package wizardtournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Student> hogwartsTeam = List.of(
                new Student("Harry Potter", 7, 50),
                new Student("Ron Weasley", 7, 45),
                new Student("Hermione Granger", 7, 60)
        );

        List<Student> durmstrangTeam = List.of(
                new Student("Viktor Krum", 7, 70),
                new Student("Igor Karkaroff Jr.", 5, 3)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur Delacour", 7, 65),
                new Student("Gabrielle Delacour", 4, 40)
        );

        Task task1 = new Task("Dragon", 500, 100);
        Task task2 = new Task("Black Lake", 800, 90);
        Task task3 = new Task("Maze", 1200, 120);

        Tournament tournament = new Tournament();
        School hogwarts = new School("hogwarts", hogwartsTeam);
        School durmstrang = new School("durmstrang", durmstrangTeam);
        School beauxbatons = new School("beauxbatons", beauxbatonsTeam);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, task2);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task3);
        CompletableFuture<Void> allTasks =
                CompletableFuture.allOf(hogwartsTask, durmstrangTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int durmstrangPoints = durmstrang.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            System.out.println("Hogwarts: " + hogwarts.getTotalPoints());
            System.out.println("Durmstrang: " + durmstrang.getTotalPoints());
            System.out.println("Beauxbatons: " + beauxbatons.getTotalPoints());

            if (hogwartsPoints > durmstrangPoints && hogwartsPoints > beauxbatonsPoints) {
                System.out.println("Hogwarts wins!");
            } else if (durmstrangPoints > hogwartsPoints && durmstrangPoints > beauxbatonsPoints) {
                System.out.println("Durmstrang wins!");
            } else if (beauxbatonsPoints > hogwartsPoints && beauxbatonsPoints > durmstrangPoints) {
                System.out.println("Beauxbatons wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }).get();
    }
}
