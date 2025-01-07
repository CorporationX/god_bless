package school.faang.task_50821;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account));
    }
}