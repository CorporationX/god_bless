package faang.school.godbless.celebrity_twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.incrementFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
