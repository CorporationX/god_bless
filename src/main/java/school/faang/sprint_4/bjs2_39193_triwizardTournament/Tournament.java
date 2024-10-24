package school.faang.sprint_4.bjs2_39193_triwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final Random RANDOM = new Random();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void startTournament(List<School> schools, List<Task> tasks) {
        List<CompletableFuture<School>> futureSchools = new ArrayList<>();
        schools.forEach(school ->
                tasks.forEach(task -> {
                    CompletableFuture<School> futureSchool = startTask(school, task);
                    futureSchools.add(futureSchool);
                }));

        resultCalculation(futureSchools);
    }

    private CompletableFuture<School> startTask(School school, Task task) {
        int difficulty = task.getDifficulty();
        String taskName = task.getName();
        String schoolName = school.getName();
        double mastery = school.getAverageMastery();

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("School {} team started task '{}', it will take '{}' seconds",
                        schoolName, taskName, difficulty);
                Thread.sleep(difficulty * 1000L);
                if (isSuccess(mastery)) {
                    school.addReward(task);
                    log.info("School {} completed task {} successfully!", schoolName, taskName);
                } else {
                    log.info("School {} failed task {}. =(", schoolName, taskName);
                }
                return school;
            } catch (InterruptedException e) {
                log.error("An error occurred while task in progress.", e);
                throw new IllegalStateException(e);
            }
        }, executor);
    }

    private void resultCalculation(List<CompletableFuture<School>> futureSchools) {
        Map<Integer, String> results = new TreeMap<>(Comparator.reverseOrder());

        CompletableFuture.allOf(futureSchools.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        futureSchools.forEach(futureSchool -> {
                            School school = futureSchool.join();
                            results.put(school.getTotalPoints(), school.getName());
                        }))
                .join();

        log.info("We are finishing the Tournament! results:");
        results.forEach((key, value) -> log.info("School {} got {} points!", value, key));
        finishTournament();
    }

    private void finishTournament() {
        log.info("TOURNAMENT IS OVER! CONGRATULATIONS!");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down now!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }

    private boolean isSuccess(double mastery) {
        return RANDOM.nextDouble() < mastery / 100;
    }
}

