package school.faang.task_51099;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        });
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }
}
