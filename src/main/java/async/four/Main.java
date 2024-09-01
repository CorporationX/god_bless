package async.four;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = new ArrayList<>();
        hogwartsStudents.add(new Student("Harry", 2, 0));
        hogwartsStudents.add(new Student("Hermione", 2, 0));
        hogwartsStudents.add(new Student("Ron", 2, 0));
        hogwartsStudents.add(new Student("Neville", 2, 0));
        hogwartsStudents.add(new Student("Ginny", 1, 0));

        List<Student> beauxbatonsStudents = new ArrayList<>();
        beauxbatonsStudents.add(new Student("Fleur", 3, 0));
        beauxbatonsStudents.add(new Student("Gabrielle", 1, 0));
        beauxbatonsStudents.add(new Student("Roger", 2, 0));
        beauxbatonsStudents.add(new Student("Angelique", 2, 0));
        beauxbatonsStudents.add(new Student("Jean", 3, 0));

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("Quidditch Match", 2, 10);
        Task task2 = new Task("Potions Class", 3, 15);

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
