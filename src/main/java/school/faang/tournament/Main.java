package school.faang.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6), new Student("Gabrielle", 6));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        List<School> schools = List.of(hogwarts, beauxbatons);

        Task task1 = new Task("Triwizard Tournament", Task.Difficulty.HARD, 100);
        Task task2 = new Task("Yule Ball Preparations", Task.Difficulty.EASY, 50);

        try (Tournament tournament = new Tournament(schools)) {
            CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
            CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
            CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
            allTasks.join();
            tournament.chooseWinner();
        }
    }
}
