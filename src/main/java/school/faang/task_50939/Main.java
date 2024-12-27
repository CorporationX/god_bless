package school.faang.task_50939;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final long LEAD_TIME = 30;

    public static void main(String[] args) {
        Tournament tournament = new Tournament(Executors.newFixedThreadPool(NUM_THREADS));

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    School winner = Stream.of(hogwarts, beauxbatons)
                            .max(Comparator.comparingInt(School::getTotalPoints))
                            .orElseThrow(NoSuchElementException::new);

                    log.info("{} became the winner, earning {} points",
                            winner.name(), winner.getTotalPoints());
                })
                .exceptionally(ex -> {
                    log.error("An error occurred during the tournament: {}",
                            ex.getMessage());
                    return null;
                });
        allTasks.join();

        tournament.finishTournament(LEAD_TIME);
        tournament = null;
        System.gc();
    }
}
