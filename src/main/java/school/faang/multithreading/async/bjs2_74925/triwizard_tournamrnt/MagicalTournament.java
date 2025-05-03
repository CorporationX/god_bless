package school.faang.multithreading.async.bjs2_74925.triwizard_tournamrnt;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Tournament tournament = new Tournament(pool);

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermion", 5, 0));

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 1, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() ->
                        Stream.of(hogwarts, beauxbatons)
                                .max(Comparator.comparing(School::getTotalPoints))
                                .ifPresent(school ->
                                        log.info("Winner with total points = {} is {}",
                                                school.getTotalPoints(), school)));


        pool.shutdown();

        try {
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Force Termination.");
                pool.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            pool.shutdownNow();
        }
    }
}
