package faang.school.godbless.mt.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final int THREAD_COUNT = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(account::addFollower, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
