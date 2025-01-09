package school.faang.task_51666;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.addFollower();
            log.info("{} added follower to {}", Thread.currentThread().getName(), account.getUserName());
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
