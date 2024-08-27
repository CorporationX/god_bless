package faang.school.godbless.celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
