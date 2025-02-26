package school.faang.becomingatwittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    private static final Object LOCK = new Object();

    public void addFollower(TwitterAccount account) {
        synchronized (LOCK) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> addFollower(account));
    }
}