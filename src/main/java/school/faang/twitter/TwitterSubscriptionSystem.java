package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    public static final int NUM_THREADS = 5;
    public static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 20; i++) {
                addFollower(account);
                log.info("User {} has 1 more subscriber", account.getUsername());
            }
            log.info("User {} now has {} subscribers", account.getUsername(), account.getFollowers());
        }, executor);
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
