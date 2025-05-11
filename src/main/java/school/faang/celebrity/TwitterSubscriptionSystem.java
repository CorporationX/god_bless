package school.faang.celebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private static final int DELAY_TIME = 500;

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(DELAY_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            addFollower(account);
        });
    }
}
