package faang.school;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        School Hogwarts = new School("Hogwarts", getStudents());
        School Durmstrang = new School("Durmstrang", getStudents());

        Task quidditch = new Task("Quidditch", 6, 15);
        Task charms = new Task("Charms", 3, 8);

        Tournament tournament = new Tournament();

        var HogwartsResult = tournament.startTask(Hogwarts, charms);
        var DurmstrangResult = tournament.startTask(Durmstrang, quidditch);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(HogwartsResult, DurmstrangResult);
        allTasks.thenRun(() -> {
            if (Hogwarts.getTotalPoints() > Durmstrang.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + Hogwarts.getName() + " with " + Hogwarts.getTotalPoints() + " points.");
            } else if (Durmstrang.getTotalPoints() > Hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + Durmstrang.getName() + " with " + Durmstrang.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Harry", 5),
                new Student("Hermione", 6),
                new Student("Ron", 7)
        );
    }
}
