package school.faang.BJS2_39022_TwitterCelebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    private void addFollower(TwitterAccount account) {
        account.addFollower();
    }
}
