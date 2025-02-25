package school.faang.sprint.fourth.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int AWAIT_TERMINATION_TIMEOUT = 10;
    private static final int THREAD_SIZE = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_SIZE);

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        log.info("Following account: {}", account.getUsername());
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for termination {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
