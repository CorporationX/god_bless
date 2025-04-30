package school.faang.magicians;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int TEN_SECONDS_IN_MS = 10_000;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 7, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 150);

        List<CompletableFuture<School>> schoolFutures = new ArrayList<>();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        schoolFutures.add(hogwartsTask);
        schoolFutures.add(beauxbatonsTask);

        School winnerSchool = schoolFutures.stream()
                .map(CompletableFuture::join)
                .max(Comparator.comparingInt(School::getPoints))
                .orElseThrow(() -> new RuntimeException("No winner could be identified, error"));
        System.out.printf("School %s with %d points wins the tournament\n", winnerSchool.getName(),
                winnerSchool.getPoints());

        ThreadPoolProvider.gracefullyShutdown();
        System.out.println("The end of the program");
    }
}
