package faang.school.godbless.become_a_celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        account.getFollowers().getAndIncrement();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> this.addFollower(account));
        return future;
    }
}
