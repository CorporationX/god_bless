package school.faang.celebritytwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        account.addFollowersToUser();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account)).join();
    }
}
