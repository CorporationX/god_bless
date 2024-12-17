package school.faang.bjs247622;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int THREADS_AMOUNT = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("Kan");
        Knight knight2 = new Knight("Chris");
        knight1.addTrial(new Trial(knight1.getName(), "battle for honor"));
        knight2.addTrial(new Trial(knight1.getName(), "test of strength"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted while waiting for ExecutorService to terminate {} ",
                    Thread.currentThread().getName());
        }

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The delivery tasks were not completed in 5 minutes, we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread was interrupted while waiting, we forcefully stop the ThreadPool {} ",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}