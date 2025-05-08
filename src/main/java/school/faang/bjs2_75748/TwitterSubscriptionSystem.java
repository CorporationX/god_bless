package school.faang.bjs2_75748;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executorService);
    }

    public void shutDownExecutor(Long minutes) {
        try {
            executorService.shutdown();
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().getAndIncrement();
    }
}
