package school.faang.celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int THREAD_COUNT = 3;
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    private void addFollower(TwitterAccount account) {
        account.followersIncrement();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void closeExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                log.error("Задачи не были завершены вовремя. Принудительная остановка.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
