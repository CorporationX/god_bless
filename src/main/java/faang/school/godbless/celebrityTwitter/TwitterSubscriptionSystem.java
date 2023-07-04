package faang.school.godbless.celebrityTwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private final Object lock = new Object();

    public TwitterSubscriptionSystem() {
    }

    public void addFollower(TwitterAccount account) {
        synchronized (lock) {
            account.getFollowers().incrementAndGet();
        }
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account));
    }

}
