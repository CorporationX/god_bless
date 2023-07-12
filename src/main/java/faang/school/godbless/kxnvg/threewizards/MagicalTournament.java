package faang.school.godbless.kxnvg.threewizards;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudent = new ArrayList<>(List.of(new Student("Mike", 16), new Student("Alan", 17),
                new Student("Harry", 14), new Student("Mary", 16)));
        List<Student> beauxbatonsStudent = new ArrayList<>(List.of(new Student("John", 18), new Student("Bob", 14),
                new Student("Liza", 17), new Student("Pol", 15)));

        School hogwarts = new School("Hogwarts", hogwartsStudent);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudent);
        Task task1 = new Task("firstTask", 4, 40);
        Task task2 = new Task("secondTask", 3, 35);

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
