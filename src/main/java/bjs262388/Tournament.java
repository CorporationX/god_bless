package bjs262388;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Tournament {
    private static final long THREAD_SLEEP_MULTIPLIER_IN_MS = 1000;
    private static final long AWAIT_TERMINATION_IN_MS = 10000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public CompletableFuture<School> startTask(School school, Task task) {
        validate(school, task);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * THREAD_SLEEP_MULTIPLIER_IN_MS);
            } catch (InterruptedException e) {
                log.error("Thread {} interrupted", Thread.currentThread().getId(),
                         new TournamentException("Interrupted exception"));
                Thread.currentThread().interrupt();
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getDifficulty());
            }
            return school;
        }, executorService).handle((result, exception) -> {
            if (result == null) {
                throw new TournamentException("Result of the points calculation is not calculated");
            }
            return result;
        });
    }

    private void validate(School school, Task task) {
        if (Objects.isNull(school.getName()) || school.getName().isEmpty()) {
            log.error("School`s name could not be null or empty",
                    new TournamentException("IllegalArgumentException"));
        }
        if (Objects.isNull(task.getName()) || task.getName().isEmpty()) {
            log.error("Task`s name could not be null or empty",
                    new TournamentException("IllegalArgumentException"));
        }
    }

    public void shutDownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
