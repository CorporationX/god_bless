package bjs262489;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int THREAD_SLEEP_IN_MS = 1000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Account1", new AtomicInteger(13));
        CompletableFuture.allOf(initializeCompletableFuture(system, account),
                        initializeCompletableFuture(system, account),
                        initializeCompletableFuture(system, account),
                        initializeCompletableFuture(system, account),
                        initializeCompletableFuture(system, account),
                        initializeCompletableFuture(system, account))
                .join();
        system.shutDownExecutorService();
    }

    private static CompletableFuture<Void> initializeCompletableFuture(TwitterSubscriptionSystem system,
                                                                       TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_IN_MS);
            } catch (InterruptedException e) {
                log.error("Adding subscriber interrupted in thread: {}", Thread.currentThread().getId());
                Thread.currentThread().interrupt();
                throw new TwitterException(e);
            }
            system.followAccount(account);
        }, system.getExecutorService());
    }
}
