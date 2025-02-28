package school.faang.task62439;

import school.faang.task62439.service.School;
import school.faang.task62439.service.Student;
import school.faang.task62439.service.Task;
import school.faang.task62439.service.Tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTask.thenRun(() -> {

            System.out.println("\nResults:");
            System.out.println(hogwarts.getName() + " total points: " + hogwarts.getTotalPoints());
            System.out.println(beauxbatons.getName() + " total points: " + beauxbatons.getTotalPoints());

            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(hogwarts.getName() + " wins the tournament!");
            }
        });
        allTask.join();
    }
}