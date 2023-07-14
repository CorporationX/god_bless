package Multithreading.bc3361_Become_a_celebrity_on_Twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount twitterAccount) {
        int followers = twitterAccount.getFollowers();
        twitterAccount.setFollowers(++followers);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addFollower(twitterAccount);
        });
    }

}
