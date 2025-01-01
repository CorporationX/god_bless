package school.faang.bjs250801;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int PROCESSING_TIME = 3000;

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            log.info("Account subscription process has started");

            try {
                Thread.sleep(PROCESSING_TIME);
            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }

            account.addFolower();
        }, executorService);
    }
}