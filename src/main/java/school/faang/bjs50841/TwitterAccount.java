package school.faang.bjs50841;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class TwitterAccount {
    private String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = new AtomicInteger(0);
    }

    public void incrementFollower() {
        followers.incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> Main.SUBSCRIPTION_SYSTEM.addFollower(account));
    }

    public int getFollowers() {
        return followers.get();
    }
}
