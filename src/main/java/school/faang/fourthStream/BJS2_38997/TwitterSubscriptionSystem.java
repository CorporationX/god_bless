package school.faang.fourthStream.BJS2_38997;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final long TERMINATION_SECONDS = 20;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void waitForCompletionAndPrint(TwitterAccount account, CompletableFuture<?>... futures) {
        CompletableFuture.allOf(futures)
                .thenRun(() -> log.info("Количество подписчиков у @{} : {}", account.getUsername(), account.getFollowers()))
                .join();

        shutdown(executor);
    }

    private void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.addFollower();
        log.info("Добавлен один подписчик");
    }
}
