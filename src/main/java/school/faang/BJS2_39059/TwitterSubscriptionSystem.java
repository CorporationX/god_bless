package school.faang.BJS2_39059;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public TwitterSubscriptionSystem() {
    }

    public synchronized void addFollower(TwitterAccount account) {
            account.getFollowers().incrementAndGet();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account));
    }
}
