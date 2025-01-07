package school.faang.sprint_4.task_50850;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        try {
            Thread.sleep(2000);
            account.getFollowers().incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
        });
    }
}
