package faang.school.godbless.multithreading.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount follower) {
        follower.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
