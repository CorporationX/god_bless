package sprint_4.sprint_4_1_async_future.celebrityInTwitter_39080;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private synchronized void addFollower(TwitterAccount account) {
        account.addFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
