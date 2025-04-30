package three.mags;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static ExecutorService executor;
    private static final int POOL_SIZE = 4;
    private static final int TIMEOUT = 10;
    private static List<Student> firstClas = new ArrayList<>(Arrays.asList(
            new Student("Harry", 16, 100),
            new Student("Vasea", 17, 150)));
    private static List<Student> secondClas = new ArrayList<>(Arrays.asList(
            new Student("Vovan", 15, 120),
            new Student("Leya", 18, 250)));

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(POOL_SIZE);
        Tournament tournament = new Tournament(executor);

        School hogwarts = new School("Hogwarts", firstClas);
        School rogaAndCopytha = new School("Roga & Copytha", secondClas);

        Task doNotDrop = new Task("Do not drop the database", 6000, 600);
        Task defeatVader = new Task("Defeat Darth Vader", 7000, 1000);

        CompletableFuture<School> firstTournament = tournament.startTask(hogwarts, doNotDrop);
        CompletableFuture<School> secondTournament = tournament.startTask(rogaAndCopytha, defeatVader);

        CompletableFuture<Void> allTournaments = CompletableFuture.allOf(firstTournament, secondTournament);
        allTournaments
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > rogaAndCopytha.getTotalPoints()) {
                        System.out.printf("School %s wins the tournament with score %d",
                                hogwarts.getName(),
                                hogwarts.getTotalPoints());
                    } else {
                        System.out.printf("School %s wins the tournament with score %d",
                                rogaAndCopytha.getName(),
                                rogaAndCopytha.getTotalPoints());
                    }
                })
                .join();

        softShutdown(executor);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Thread isn t terminated in time! Forced Shutdown!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Player thread is interrupted! {}", e.getCause().getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
