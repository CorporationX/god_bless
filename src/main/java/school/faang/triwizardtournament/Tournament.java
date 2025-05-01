package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament implements Closeable {
    private static final int THREAD_COUNT = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread was interrupted while sleeping", e);
                throw new RuntimeException("Thread was interrupted while sleeping", e);
            }
            school.students().forEach(s -> s.gainPoints(task.reward()));
            return school;
        }, executor);
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                log.info("Shutting down executor...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while shutting down", e);
            throw new RuntimeException("Thread was interrupted while shutting down", e);
        }
    }
}
