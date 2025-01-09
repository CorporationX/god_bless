package school.faang.bjs251771;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;


public class TwitterSubscriptionSystem {
    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }
}
