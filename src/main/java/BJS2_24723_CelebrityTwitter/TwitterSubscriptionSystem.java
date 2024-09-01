package BJS2_24723_CelebrityTwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount twitterAccount) {
        synchronized (this) {
            twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
                Thread.currentThread().interrupt();
            }
            addFollower(twitterAccount);
        });
    }
}
