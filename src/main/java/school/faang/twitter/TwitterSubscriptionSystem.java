package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int ONE_SECOND_IN_MS = 1000;

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        log.debug("Following account: {}", account);
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            try {
                Thread.sleep(ONE_SECOND_IN_MS);
            } catch (InterruptedException e) {
                log.debug("Thread was interrupted", e);
            }
        }, ThreadPullProvider.executor);
    }

    private void addFollower(TwitterAccount account) {
        log.debug("Adding follower: {}", account);
        account.addOneFollower();
    }
}
