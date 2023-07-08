package becoming_celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            account.addFollower();
            System.out.println("Added follower to account: " + account.getUsername());
        });
    }
}
