package ru.kraiush.BJS2_38944;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account)).join();
    }
}
