package school.faang.task_50763;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Tournament {
    private final ExecutorService executor;

    public Tournament(ExecutorService executor) {
        this.executor = executor;
    }

    public void startTournament(List<School> schools, List<Task> tasks) {
        List<CompletableFuture<School>> futureSchools = schools.stream()
                .flatMap(school -> tasks.stream()
                        .map(task -> startTask(school, task)))
                .toList();

        CompletableFuture.allOf(futureSchools.toArray(new CompletableFuture[0]))
                .thenApply(v -> futureSchools.stream()
                        .map(CompletableFuture::join)
                        .toList())
                .thenAccept(results -> {
                    Map<Integer, String> sortedResults = new TreeMap<>(Comparator.reverseOrder());
                    results.forEach(school -> sortedResults.put(school.getTotalPoints(), school.getName()));

                    log.info("Tournament Results:");
                    sortedResults.forEach((points, name) ->
                            log.info("{} scored {} points", name, points));
                })
                .join();

        finishTournament();
    }

    private CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.getDifficulty() * Constants.TASK_DIFFICULTY_MULTIPLIER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Task '{}' interrupted for school '{}'", task.getName(), school.getName(), e);
            }

            school.addReward(task);
            log.info("Task '{}' completed for school '{}'", task.getName(), school.getName());
            return school;
        }, executor);
    }

    private void finishTournament() {
        executor.shutdown();
    }
}