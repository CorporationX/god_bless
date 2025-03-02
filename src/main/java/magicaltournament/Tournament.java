package magicaltournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int TERMINATION_TIME_SEC = 60;
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

    CompletableFuture<School> startTask(School school, Task task) {
        log.info("{} started the task: {}", school.getName(), task.getName());
        CompletableFuture<School> taskFuture = new CompletableFuture<>();

        EXECUTOR.schedule(() -> {
            try {
                school.getTeam().forEach(student -> {
                    student.addPoints(task.getReward());
                    log.info("Student {} from {} school completed task: {}. Points gained: {}",
                            student.getName(), school.getName(), task.getName(), task.getReward());
                });
                taskFuture.complete(school);
            } catch (Exception e) {
                log.error("Error while processing task '{}' for school '{}'", task.getName(), school.getName(), e);
                taskFuture.completeExceptionally(e);
            }
        }, task.getDifficulty(), TimeUnit.SECONDS);

        return taskFuture;
    }


    void shutdown() {
        log.info("Shutting down the tournament...");
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_TIME_SEC, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in time, forcing shutdown.");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown interrupted", e);
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Tournament shutdown complete.");
    }
}
