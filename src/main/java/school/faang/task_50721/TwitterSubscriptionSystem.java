package school.faang.task_50721;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private final ExecutorService executorService;

    public TwitterSubscriptionSystem(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(Constants.SUBSCRIPTION_SIMULATION_DELAY.getValue());
            } catch (InterruptedException e) {
                log.error("Subscription interrupted for {}: {}", account.getUsername(), e.getMessage());
            }
            account.addFollower();
            log.info("One person subscribed to {}", account.getUsername());
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(Constants.AWAIT_TERMINATION_TIMEOUT.getValue(), TimeUnit.SECONDS)) {
                log.warn("Tasks did not complete in time. Forcing shutdown.");
                executorService.shutdownNow();
            } else {
                log.info("All tasks completed successfully.");
            }
        } catch (InterruptedException e) {
            log.error("Error during ExecutorService shutdown: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}