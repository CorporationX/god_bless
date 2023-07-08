package faang.school.godbless.sprint4.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount twitterAccount) {
        synchronized (this) {
            int followers = twitterAccount.getFollowers();
            twitterAccount.setFollowers(followers + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                addFollower(twitterAccount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
