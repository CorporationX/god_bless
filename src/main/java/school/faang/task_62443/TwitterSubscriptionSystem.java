package school.faang.task_62443;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int SLEEP_TIME = 2_000;

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error("Sleep was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }).thenRun(() -> log.info("A follower has been added to {}", account.getUsername()));
    }
}
