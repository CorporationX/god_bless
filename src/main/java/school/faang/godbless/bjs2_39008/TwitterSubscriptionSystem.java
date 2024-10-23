package school.faang.godbless.bjs2_39008;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private final ExecutorService pool = Executors.newCachedThreadPool();

    private void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), pool);
    }

    public void shutdown() {
        pool.shutdown();
    }
}
