package school.faang.task_50678;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class TwitterSubscriptionSystem {
    private static final int SUBSCRIPTION_SIMULATION_DELAY = 500;

    private final ExecutorService executorService;

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SUBSCRIPTION_SIMULATION_DELAY);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            account.addFollower();
            log.info("One person subscribed to {}", account.getUsername());
        }, executorService);
    }
}