package school.faang.BJS2_64794;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        });
    }

}
