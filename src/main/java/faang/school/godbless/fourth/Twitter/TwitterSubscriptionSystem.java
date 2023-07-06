package faang.school.godbless.fourth.Twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addFollower(account);
        });
    }
}
