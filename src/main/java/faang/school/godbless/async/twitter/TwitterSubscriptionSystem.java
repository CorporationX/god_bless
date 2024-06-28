package faang.school.godbless.async.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

}
