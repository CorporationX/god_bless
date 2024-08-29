package faang.school.godbless.TwitterCelebrity;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (twitterAccount) {
                addFollower(twitterAccount);
            }
        }, executorService);
    }
}
