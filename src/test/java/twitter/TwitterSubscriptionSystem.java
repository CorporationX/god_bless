package twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private final int THREAD_COUNT = 3;
    private ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
        },executorService);
    }
}
