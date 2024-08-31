package celebrity.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
