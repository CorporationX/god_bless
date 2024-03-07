package faang.school.godbless.twittercelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executorService);
    }

    public void shutDownAndAwaitExecutor(Long minutes) {
        executorService.shutdown();
        awaitTermination(minutes);
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    private void awaitTermination(Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
