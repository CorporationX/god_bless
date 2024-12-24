package school.faang.task_50880;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainApp {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task3 = new Task("Dragon teach", 10, 150);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task4 = new Task("Kill Demon Lord ", 15, 250);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task4);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task3);

        System.out.println("Total Point of School: " + hogwarts.getTotalPoints());
        System.out.println("Total Point of School: " + beauxbatons.getTotalPoints());

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, beauxbatonsTask2,
                hogwartsTask2);
        allTasks.join();

        System.out.println("Total Point of School: " + hogwarts.getTotalPoints());
        System.out.println("Total Point of School: " + beauxbatons.getTotalPoints());
    }
}
