package school.faang.becoming_a_celebrity_on_twitter.BJS2_62552;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public CompletableFuture<Void> followAccount(@NonNull TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    private synchronized void addFollower(@NonNull TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1L);
    }
}
