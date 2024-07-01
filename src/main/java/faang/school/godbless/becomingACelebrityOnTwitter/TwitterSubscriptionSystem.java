package faang.school.godbless.becomingACelebrityOnTwitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
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
