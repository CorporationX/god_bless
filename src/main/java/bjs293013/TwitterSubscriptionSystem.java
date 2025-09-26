package bjs293013;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        });
    }
}
