package school.faang.m1.future.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem implements AutoCloseable {

    private final ExecutorService exec =
            Executors.newFixedThreadPool(Math.min(4, Math.max(1, Runtime.getRuntime().availableProcessors())));

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), exec);
    }

    @Override
    public void close() {
        exec.shutdown();
    }
}
