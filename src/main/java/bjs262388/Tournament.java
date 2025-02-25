package bjs262388;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);
    private static final long THREAD_SLEEP_MULTIPLIER_IN_MS = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * THREAD_SLEEP_MULTIPLIER_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("{} interrupted", Thread.currentThread().getId(),
                        new TournamentException("Interrupted exception", e));
            }
            for (Student student : school.getTeam()) {
                student.addPoints(student, task.getDifficulty());
            }
            return school;
        }, EXECUTOR_SERVICE).handle((result, exception) -> {
            if (result == null) {
                throw new TournamentException("Result of the points calculation is not calculated");
            }
            return result;
        });
    }
}
