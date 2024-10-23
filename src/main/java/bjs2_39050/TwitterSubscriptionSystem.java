package bjs2_39050;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account, TwitterAccount subscriber) {
        return CompletableFuture.runAsync(() -> account.addFollower(subscriber));
    }
}
