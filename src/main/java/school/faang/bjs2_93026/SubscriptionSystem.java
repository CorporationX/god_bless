package school.faang.bjs2_93026;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SubscriptionSystem {
    private final ExecutorService ex = Executors.newFixedThreadPool(5);

    public synchronized void addFollower(TwitterAccount account) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            log.error("Follow has been interrupted");
            Thread.currentThread().interrupt();
        }
        account.setFollowers(account.getFollowers() + 1);
        log.info("Added follower to {}. Number of follower: {}", account.getUsername(), account.getFollowers());
    }


    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), ex);
    }

    public CompletableFuture<Void> followMultipleTimes(List<TwitterAccount> accounts) {
        List<CompletableFuture<Void>> futures = accounts.stream()
                        .map(this::followAccount)
                .toList();
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }


    public void exShutdown() {
        ex.shutdown();
        try {
            if (!ex.awaitTermination(15, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e.getMessage());
        }
    }
}
