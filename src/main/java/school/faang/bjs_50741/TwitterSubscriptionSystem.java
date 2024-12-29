package school.faang.bjs_50741;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int SLEEP_TIME = 500;

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> addFollower(account));
    }

    private synchronized TwitterAccount addFollower(TwitterAccount account) {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Sleep interrupted", e);
        }

        account.setFollowers(account.getFollowers() + 1);
        log.info("Add follower for account {}", account.getUserName());
        return account;
    }
}
