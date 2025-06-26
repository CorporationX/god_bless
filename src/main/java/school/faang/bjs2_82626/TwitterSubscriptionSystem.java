package school.faang.bjs2_82626;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
