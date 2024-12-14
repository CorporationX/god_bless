package school.faang.Twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> future = CompletableFuture
                .runAsync(() -> addFollower(account), executorService)
                .exceptionally(e -> {
                    log.error("не удалось пдписаться {}", e.getMessage());
                    executorService.shutdownNow();
                    throw new IllegalStateException(e);
                });

        executorService.shutdown();

        return future;
    }

    private void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.incrementFollowers();
        }
    }
}
