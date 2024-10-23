package school.faang.celebruty.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    private void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
