package school.faang.bjs2_74964;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int SCHOOLS_COUNT = 2;
    private static final int TERMINATION_WAIT_DURATION = 10000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(SCHOOLS_COUNT);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * 1000);
            } catch (InterruptedException e) {
                log.error("Interrupted exception was thrown", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.students()
                    .forEach(student -> student.addPoints(task.reward()));
            return school;
        }, executorService);
    }

    public void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_WAIT_DURATION, TimeUnit.SECONDS)) {
                log.warn("Not all tasks finished successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception was thrown", e);
            executorService.shutdownNow();
        }
    }
}