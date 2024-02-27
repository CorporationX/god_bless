package faang.school.godbless.twittercelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {

    private final Object ACCOUNT_LOCK = new Object();
    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), EXECUTOR_SERVICE);
    }

    public void shutDownAndAwaitExecutor(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(minutes);
    }

    private void addFollower(TwitterAccount account) {
        synchronized (ACCOUNT_LOCK) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    private void awaitTermination(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
