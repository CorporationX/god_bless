package school.faang.task_50695;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        account.getFollowers().addAndGet(1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);

            return account;
        });
    }
}
