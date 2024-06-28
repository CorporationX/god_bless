package faang.school.godbless.HogwartsBattle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student harry = new Student("Harry Potter", "Year 5", 0);
        Student hermione = new Student("Hermione Granger", "Year 5", 0);
        Student ron = new Student("Ron Weasley", "Year 5", 0);
        List<Student> hogwartsTeam = Arrays.asList(harry, hermione, ron);

        Student fleur = new Student("Professor Snape", "Year 4", 0);
        Student gabrielle = new Student("Draco Malfoy", "Year 3", 0);
        List<Student> slytherinTeam = Arrays.asList(fleur, gabrielle);

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School slytherin = new School("Slyherin", slytherinTeam);

        Task task1 = new Task("Potion Making", 50, 100);
        Task task2 = new Task("Flying Lessons", 30, 1000);


        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> slytherinTask = tournament.startTask(slytherin, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, slytherinTask);
        allTasks.thenRun(() -> {
            int hogwartsTotalPoints = hogwarts.getTotalPoints();
            int slytherinTotalPoints = slytherin.getTotalPoints();

            if (hogwartsTotalPoints > slytherinTotalPoints) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwartsTotalPoints + " points.");
            } else if (slytherinTotalPoints > hogwartsTotalPoints) {
                System.out.println("The winner of the magical tournament is " + slytherin.getName() + " with " + slytherinTotalPoints + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}


