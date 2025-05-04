package school.faang.multithreading.async.bjs2_74788.twitter_celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private final ExecutorService pool = Executors.newCachedThreadPool();

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            log.info("Follower added to account: {}", account.getUsername());
        }, pool);
    }

    public void shutdown() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Force Termination.");
                pool.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            pool.shutdownNow();
        }
    }
}
