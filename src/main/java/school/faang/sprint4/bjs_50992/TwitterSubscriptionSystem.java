package school.faang.sprint4.bjs_50992;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(increment(account));
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    private synchronized int increment(TwitterAccount account) {
        return account.getFollowers() + 1;
    }
}
