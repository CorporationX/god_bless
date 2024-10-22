package school.faang.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final int THREAD_POOL_SIZE = 8;
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public synchronized void addFollower(TwitterAccount account) {
            account.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
