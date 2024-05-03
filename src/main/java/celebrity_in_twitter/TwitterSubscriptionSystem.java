package celebrity_in_twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        checkAccount(account);
        return CompletableFuture.runAsync(() -> addFollower(account), SERVICE);
    }

    private void checkAccount(TwitterAccount account) {
        if (account == null) {
            throw new NullPointerException("Account must be exist");
        }
    }

    public void shutdown() {
        SERVICE.shutdown();
    }
}
