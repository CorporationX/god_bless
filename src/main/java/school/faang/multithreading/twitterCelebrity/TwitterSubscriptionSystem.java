package school.faang.multithreading.twitterCelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private synchronized void addFollower(TwitterAccount account) {
        account.incrementFollowersBy(1);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> addFollower(account), executor);
        future.join();
        executor.shutdown();
    }
}
