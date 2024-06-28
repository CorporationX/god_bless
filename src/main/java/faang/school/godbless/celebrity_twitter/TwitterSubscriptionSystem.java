package faang.school.godbless.celebrity_twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, Executor executor) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
