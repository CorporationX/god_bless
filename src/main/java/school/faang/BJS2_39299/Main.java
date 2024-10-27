package school.faang.BJS2_39299;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        School hogwartsSchool = new School("Hogwarts", hogwartsTeam);
        School beauxbatonsSchool = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preperation", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwartsSchool, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatonsSchool, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwartsSchool.getTotalPoints();
            int beauxbatonsPoints = beauxbatonsSchool.getTotalPoints();

            System.out.println("Hogwarts Total Points: " + hogwartsPoints);
            System.out.println("Beauxbatons Total Points: " + beauxbatonsPoints);

            if (hogwartsPoints > beauxbatonsPoints) {
                System.out.println("Hogwarts wins the tournament!");
            } else if (beauxbatonsPoints > hogwartsPoints) {
                System.out.println("Beauxbatons wins the tournament!");
            } else {
                System.out.println("It's a tie!");
            }
        }).join();
    }
}
