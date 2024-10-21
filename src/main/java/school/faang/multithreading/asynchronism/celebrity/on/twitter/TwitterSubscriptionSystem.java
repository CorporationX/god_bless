package school.faang.multithreading.asynchronism.celebrity.on.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }
}
