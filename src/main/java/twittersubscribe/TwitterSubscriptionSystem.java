package twittersubscribe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int TERMINATION_TIMEOUT_SEC = 60;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS);

    public CompletableFuture<Void> followAccount(TwitterAccount account, int followerNumber) {
        return CompletableFuture.runAsync(() -> addFollower(account, followerNumber), EXECUTOR);
    }

    public void addFollower(TwitterAccount account, int followerNumber) {
        account.increaseFollowers();
        log.info("Added follower #{} to account: {}", followerNumber, account.getUsername());
    }

    void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
                if (!EXECUTOR.awaitTermination(TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                    log.warn("Unable to properly shutdown the executor!");
                }
            }
        } catch (InterruptedException e) {
            log.error("Executor termination was interrupted.", e);
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
