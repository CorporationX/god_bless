package school.faang.we_become_celebrity_on_twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            log.info("Added follower to {}. Total followers: {}", account.getUsername(), account.getFollowers());
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
