package school.faang.becomeTwitterCelebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2_000);
                addFollower(account);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenRun(() -> System.out.println(account.getUsername() + " gained subscriber."))
                .join();
    }
}
