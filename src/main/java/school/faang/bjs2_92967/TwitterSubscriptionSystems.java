package school.faang.bjs2_92967;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystems {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}