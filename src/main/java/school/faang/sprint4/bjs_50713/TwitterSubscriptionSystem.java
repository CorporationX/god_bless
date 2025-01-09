package school.faang.sprint4.bjs_50713;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int SLEEP_TIME = 1000;

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
                account.addFollower();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Process was interrupted");
            }
        });
    }
}
