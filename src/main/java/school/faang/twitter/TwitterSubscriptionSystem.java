package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem implements AutoCloseable {

    private final Object lock = new Object();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    private void addFollower(TwitterAccount account) {
        log.info("Add follower to account: {}", account.getUsername());
        synchronized (lock) {
            account.addFollower();
            log.info(
                    "Added follower to account: {}. Current followers: {}",
                    account.getUsername(), account.getFollowers()
            );
        }
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
