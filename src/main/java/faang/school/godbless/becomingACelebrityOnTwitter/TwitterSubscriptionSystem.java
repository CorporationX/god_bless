package faang.school.godbless.becomingACelebrityOnTwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public void followAccount(TwitterAccount account) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CompletableFuture.runAsync(() -> {
            addFollower(account);
        });
    }
}
