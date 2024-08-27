package faang.school.godbless.BJS2_24738;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), executor);
    }
}
