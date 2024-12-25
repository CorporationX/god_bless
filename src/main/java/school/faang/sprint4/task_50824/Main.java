package school.faang.sprint4.task_50824;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6), new Student("Gabrielle", 6));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", Difficulty.HARD);
        Task task2 = new Task("Yule Ball Preparations", Difficulty.EASY);

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();

        List<School> participants = List.of(hogwarts, beauxbatons);
        System.out.println("The winner of tournament is: " + tournament.calculateWinner(participants));
    }
}
