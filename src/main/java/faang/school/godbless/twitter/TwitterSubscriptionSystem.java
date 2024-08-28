package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100L, 1000L));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            addFollower(account);
        });
    }
}
