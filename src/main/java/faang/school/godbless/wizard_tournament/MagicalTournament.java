package faang.school.godbless.wizard_tournament;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        Student harry = new Student("Harry Potter", 5);
        Student hermione = new Student("Hermione Granger", 5);
        Student fleur = new Student("Fleur Delacour", 6);

        hogwarts.addStudent(harry);
        hogwarts.addStudent(hermione);
        beauxbatons.addStudent(fleur);

        Task task1 = new Task("Defeat the dragon", 8, 10);
        Task task2 = new Task("Solve the riddle", 5, 7);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
