package celebintwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        account.getFollowersCount().incrementAndGet();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account));
    }
}
