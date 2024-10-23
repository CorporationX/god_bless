package school.faang.TheWizardsTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class Tournament {
    private final int THREAD_POOL_SIZE = 10;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public CompletableFuture<School> startTask(School school, Task task) {
        Supplier<School> completingTask = () -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new IllegalStateException("Task interrupted " + e.getMessage(), e);
            }
            return school;
        };

        Function<Throwable, School> exceptionHandler = (e -> {
            executorService.shutdownNow();
            log.error(e.getMessage());
            throw new IllegalStateException("Task interrupted " + e.getMessage(), e);
        });

        return CompletableFuture.supplyAsync(completingTask, executorService)
                .thenApply(schoolInstance -> schoolInstance.earnPoints(task.getReward()))
                .exceptionally(exceptionHandler);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
