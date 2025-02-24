package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        log.info("Followed to {}", account.getUsername());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep interrupted in method \"followAccount\"");
                throw new RuntimeException(e);
            }
            addFollower(account);
            log.info("{} now has {} subscribers.", account.getUsername(), account.getFollowers());
        }, executor);
    }
}
