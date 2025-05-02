package school.faang.big_bang_theory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREADS_AMOUNT = 4;
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);

        executor.execute(new Task("Sheldon", "theory preparation"));
        executor.execute(new Task("Leonard", "experiment modeling"));
        executor.execute(new Task("Howard", "tool development"));
        executor.execute(new Task("Rajesh", "data analysis"));

        softShutdown(executor);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        termimation(executor);
    }

    private static void termimation(ExecutorService executor) {
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Timeout exceeded — forcing shutdown...");
                executor.shutdownNow();
            } else {
                log.info("All tasks completed successfully.");
            }
        } catch (InterruptedException e) {
            log.error("Shutdown was interrupted.", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
