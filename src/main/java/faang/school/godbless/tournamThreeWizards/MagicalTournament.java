package faang.school.godbless.tournamThreeWizards;

import java.util.concurrent.CompletableFuture;
import static java.util.Arrays.*;

public class MagicalTournament {
    public static void main(String[] args) {
        Student student1 = new Student("Harry Potter", 4, 0);
        Student student2 = new Student("Hermione Granger", 4, 0);
        Student student3 = new Student("Luna Lovegood", 2, 0);


        School hogwarts = new School("Hogwarts School of Witchcraft and Wizardry", asList(student1, student2));
        School beauxbatons = new School("Beauxbatons Academy of Magic", asList(student3));

        Task task1 = new Task("Retrieve the Golden Snitch", 5, 10);
        Task task2 = new Task("Defeat the Dragon", 8, 15);

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            Tournament.printResults(hogwarts, beauxbatons, task1, task2);
            System.out.println("The magical tournament ended in a tie!");
        }).join();
    }
}
