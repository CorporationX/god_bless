package school.faang.bjs2_93026;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SubscriptionSystem {
    private static final long SHUTDOWN_TIMEOUT_SECONDS = 15;

    private final ExecutorService ex = Executors.newFixedThreadPool(5);
    private final AtomicInteger followCounter = new AtomicInteger();

    private void addFollower(TwitterAccount followerAccount, TwitterAccount targetAccount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error("Follow has been interrupted");
            Thread.currentThread().interrupt();
            return;
        }
        int newTargetsFollowers = targetAccount.getFollowers().incrementAndGet();
        followCounter.incrementAndGet();
        log.info("User {} followed  {}. Number of followers: {}", followerAccount.getUsername(),
                targetAccount.getUsername(), newTargetsFollowers);
    }


    private CompletableFuture<Void> followAccount(TwitterAccount followerAccount, TwitterAccount targetAccount) {
        return CompletableFuture.runAsync(() -> addFollower(followerAccount, targetAccount), ex);
    }

    public CompletableFuture<Void> followMultipleTimes(List<TwitterAccount> followers, TwitterAccount target) {
        List<CompletableFuture<Void>> futures = followers.stream()
                .map(follower -> followAccount(follower, target))
                .toList();
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenRunAsync(() -> log.info("All {} follow operations completed. Total followers added: {}",
                        followers.size(), followCounter.get()))
                .exceptionally(ex -> {
                    log.error("Error during follow operations: {}", ex.getMessage());
                    return null;
                });
    }

    public void exShutdown() {
        ex.shutdown();
        try {
            if (!ex.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e.getMessage());
        }
    }
}
