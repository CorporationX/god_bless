package school.faang.celebrityintwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account)).join();
    }
}
