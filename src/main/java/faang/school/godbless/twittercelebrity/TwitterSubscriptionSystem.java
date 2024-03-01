package faang.school.godbless.twittercelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {
    private final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private final Object LOCK = new Object();

    private void addFollower(TwitterAccount account) {
        synchronized (LOCK) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), EXECUTOR);
    }

    public void shutDownAndAwait(int time) {
        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(time, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
