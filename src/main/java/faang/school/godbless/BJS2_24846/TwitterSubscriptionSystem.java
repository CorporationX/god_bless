package faang.school.godbless.BJS2_24846;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(account::addFollower);
    }
}
