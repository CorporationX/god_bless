package faang.school.godbless.fourth.Tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student harry = new Student("Harry Potter", 10);
        Student hermione = new Student("Hermione Granger", 10);
        Student ron = new Student("Ron Weasley", 10);
        Student bib = new Student("Bib", 11);
        Student bob = new Student("Bob", 10);
        Student bab = new Student("Bab", 9);

        School hogwarts = new School("Hogwarts", List.of(harry, hermione, ron));
        School someSchool = new School("Some school", List.of(bib, bob, bab));

        Task task1 = new Task("Catch the troll", Difficulty.HARD, 100);
        Task task2 = new Task("Сatch the butterfly", Difficulty.EASY, 10);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> someSchoolTask = tournament.startTask(someSchool, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, someSchoolTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > someSchool.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.name() + " with "
                        + hogwarts.getTotalPoints() + " points.");
            } else if (someSchool.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + someSchool.name() + " with "
                        + someSchool.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
