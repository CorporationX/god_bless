package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        account.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            log.info("Добавлен подписчик для {}", account.getUsername());
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
