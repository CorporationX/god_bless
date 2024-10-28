package becoming_a_celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {
    private static final Object LOCK = new Object();

    /**
     * Increments the follower count of a {@link TwitterAccount} in a thread-safe
     * manner.
     *
     * @param account The account to add a follower to.
     */
    private void addFollower(TwitterAccount account) {
        synchronized (LOCK) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    /**
     * Adds a follower to a Twitter account in a thread-safe manner.
     *
     * @param account         The account to add the follower to.
     * @param executorService The executor service used to execute the task.
     */
    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        }, executorService);
    }
}
