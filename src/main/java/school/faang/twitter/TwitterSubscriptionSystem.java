package school.faang.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
            account.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
