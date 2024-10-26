package dima.evseenko.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private ExecutorService executor = Executors.newCachedThreadPool();

    private synchronized TwitterAccount addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        return twitterAccount;
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount twitterAccount) {
        if (executor.isShutdown()) {
            executor = Executors.newCachedThreadPool();
        }

        CompletableFuture<TwitterAccount> future = CompletableFuture.supplyAsync(() -> addFollower(twitterAccount), executor);

        executor.shutdown();

        return future;
    }
}
