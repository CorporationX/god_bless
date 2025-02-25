package school.faang.task_62449;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int START_POINTS = 0;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, START_POINTS),
                new Student("Hermione", 5, START_POINTS)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, START_POINTS),
                new Student("Gabrielle", 6, START_POINTS)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        tournament.determineWinner(List.of(hogwartsTask, beauxbatonsTask), hogwarts, beauxbatons);
    }
}
