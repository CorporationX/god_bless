package faang.school.godbless.CelebrityOnTwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
