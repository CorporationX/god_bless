package faang.school.godbless.BJS2_24991;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = new ArrayList<>();
        hogwartsStudents.add(new Student("Ruslan", 3, 5));
        hogwartsStudents.add(new Student("Harry", 3, 7));
        hogwartsStudents.add(new Student("Ron", 3, 9));

        List<Student> beauxbatonsStudents = new ArrayList<>();
        beauxbatonsStudents.add(new Student("Hermiona", 4, 10));
        beauxbatonsStudents.add(new Student("Drago", 4, 8));
        beauxbatonsStudents.add(new Student("Oleg", 4, 12));


        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("Find the red stone", 5, 15);
        Task task2 = new Task("Learn the spell", 9, 30);

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
