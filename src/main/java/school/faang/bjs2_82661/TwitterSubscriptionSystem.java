package school.faang.bjs2_82661;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
