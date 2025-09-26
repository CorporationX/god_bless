package school.faang.tournament.of.three.wizards;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public record Tournament(ExecutorService executor) implements AutoCloseable {
    private static final long TIME_FOR_WAITING = 1000L;
    private static final long SHUTDOWN_TIMEOUT_SECONDS = 30L;

    public static School determineWinner(List<School> schools) {
        return schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElseThrow(() -> new IllegalStateException("No schools provided"));
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * TIME_FOR_WAITING);

                school.awardPointsToTeam(task.reward());

                return school;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task was interrupted", e);
            }
        }, executor);
    }

    @Override
    public void close() {
        shutdown();
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in time, forcing shutdown...");
                executor.shutdownNow();

                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    log.error("Executor did not terminate even after shutdownNow");
                }
            }
        } catch (InterruptedException e) {
            log.warn("Shutdown was interrupted, forcing immediate shutdown");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
