package school.faang.bjs250859;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final AtomicInteger followers = new AtomicInteger(0);
    ExecutorService executorService;

    public TwitterSubscriptionSystem(Constants threadCount) {
        this.executorService = Executors.newFixedThreadPool(threadCount.getValue());
    }

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        log.info("Added a follower to the account: {}", account);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(Constants.SUBSCRIPTION_SIMULATION_DELAY.getValue());
            } catch (InterruptedException e) {
                log.error("Subscription interrupted for {}: {}", account.getUsername(), e.getMessage());
            }
            addFollower(account);
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
