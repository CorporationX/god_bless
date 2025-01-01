package school.faang.task_51899;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int HOGWARTS_TEAM_YEAR = 5;
    private static final int BEAUXBATONS_TEAM_YEAR = 6;
    private static final int TASK1_DIFFICULTY = 10;
    private static final int TASK1_REWARD = 100;
    private static final int TASK2_DIFFICULTY = 5;
    private static final int TASK2_REWARD = 50;
    private static final int START_POINTS = 0;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", HOGWARTS_TEAM_YEAR, START_POINTS),
                new Student("Hermione", HOGWARTS_TEAM_YEAR, START_POINTS)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", BEAUXBATONS_TEAM_YEAR, START_POINTS),
                new Student("Gabrielle", BEAUXBATONS_TEAM_YEAR, START_POINTS)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", TASK1_DIFFICULTY, TASK1_REWARD);
        Task task2 = new Task("Yule Ball Preparations", TASK2_DIFFICULTY, TASK2_REWARD);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        tournament.determineWinner(List.of(hogwartsTask, beauxbatonsTask), hogwarts, beauxbatons);
    }
}
