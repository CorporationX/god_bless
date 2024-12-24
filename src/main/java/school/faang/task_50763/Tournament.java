package school.faang.task_50763;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final Random RANDOM = new Random();
    private final ExecutorService executor;

    public Tournament(ExecutorService executor) {
        this.executor = executor;
    }

    public void startTournament(List<School> schools, List<Task> tasks) {
        List<CompletableFuture<School>> futureSchools = schools.stream()
                .flatMap(school -> tasks.stream()
                        .map(task -> startTask(school, task)))
                .toList();

        calculateResults(futureSchools);
    }

    private CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("School {} begins task '{}' ({} seconds)",
                        school.getName(), task.getName(), task.getDifficulty());
                Thread.sleep((long) task.getDifficulty() * Constants.TASK_DIFFICULTY_MULTIPLIER);

                if (isSuccess(school.getAverageMastery())) {
                    school.addReward(task);
                    log.info("School {} successfully completed task '{}'", school.getName(), task.getName());
                } else {
                    log.warn("School {} failed task '{}'", school.getName(), task.getName());
                }
            } catch (InterruptedException e) {
                log.error("Task '{}' interrupted for school '{}'", task.getName(), school.getName(), e);
            }
            return school;
        }, executor);
    }

    private void calculateResults(List<CompletableFuture<School>> futureSchools) {
        Map<Integer, String> results = new TreeMap<>(Comparator.reverseOrder());

        CompletableFuture.allOf(futureSchools.toArray(new CompletableFuture[0]))
                .thenRun(() -> futureSchools.forEach(future -> {
                    School school = future.join();
                    results.put(school.getTotalPoints(), school.getName());
                }))
                .join();

        log.info("Tournament Results:");
        results.forEach((points, school) -> log.info("{} scored {} points", school, points));

        finishTournament();
    }

    private void finishTournament() {
        log.info("TOURNAMENT FINISHED!");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(Constants.EXECUTOR_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in time. Shutting down now!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error during executor shutdown", e);
        }
    }

    private boolean isSuccess(double mastery) {
        return RANDOM.nextDouble() < mastery / 100;
    }
}