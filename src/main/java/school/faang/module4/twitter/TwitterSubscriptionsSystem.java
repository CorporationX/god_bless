package school.faang.module4.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionsSystem {
    private static final long ADD_FOLLOWER_SLEEP_IN_MS = 1_000L;

    private void addFollower(TwitterAccount account) {
        synchronized (account) {
            try {
                Thread.sleep(ADD_FOLLOWER_SLEEP_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            account.addFollower();
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
