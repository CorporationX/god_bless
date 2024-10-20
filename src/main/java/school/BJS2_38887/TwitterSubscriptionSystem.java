package school.BJS2_38887;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
        });
    }
}
