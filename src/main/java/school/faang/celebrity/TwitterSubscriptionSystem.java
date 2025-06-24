package school.faang.celebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        account.followersIncrement();
    }

    public void followAccount(TwitterAccount account, int newFollowersCount) {
        CompletableFuture<Void>[] futures = new CompletableFuture[newFollowersCount];

        for (int i = 0; i < newFollowersCount; i++) {
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                addFollower(account);
                return null;
            });
            futures[i] = future;
        }

        CompletableFuture.allOf(futures).join();
    }
}
