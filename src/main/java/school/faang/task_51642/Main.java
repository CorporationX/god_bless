package school.faang.task_51642;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 10);
        Task task2 = new Task("Yule Ball Preparations", 5, 20);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            System.out.println("All tasks completed. Calculating results...");

            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            if (hogwartsPoints > beauxbatonsPoints) {
                System.out.println("Winner: " + hogwarts.getName() + " with " + hogwartsPoints + " points!");
            } else if (beauxbatonsPoints > hogwartsPoints) {
                System.out.println("Winner: " + beauxbatons.getName() + " with " + beauxbatonsPoints + " points!");
            } else {
                System.out.println("It's a tie! Both schools have " + hogwartsPoints + " points!");
            }
        }).join();
    }
}
