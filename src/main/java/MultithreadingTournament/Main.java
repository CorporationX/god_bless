package MultithreadingTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);


        CompletableFuture<School> hogwartsTaskResult = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTaskResult = tournament.startTask(beauxbatons, task1);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTaskResult, beauxbatonsTaskResult);

        allTasks.join();
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner is " + hogwarts.getName());
            } else {
                System.out.println("The winner is " + beauxbatons.getName());
            }
        });
    }
}
