package faang.school.godbless.mt.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(account::addFollower);
    }
}
