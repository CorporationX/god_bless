package school.faang.asynchrony.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final int THREAD_POOL_SIZE = 5;
    private final ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void addFollower(TwitterAccount account) {
        CompletableFuture.runAsync(() -> account.getFollowers().incrementAndGet());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), service);
    }

    public void shutDown() {
        service.shutdown();
    }
}
