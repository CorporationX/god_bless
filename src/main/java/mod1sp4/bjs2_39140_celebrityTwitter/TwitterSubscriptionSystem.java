package mod1sp4.bjs2_39140_celebrityTwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class TwitterSubscriptionSystem {

    private final int AMOUNT_THREAD = 12;
    private final ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_THREAD);

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executorService);
    }

    public void addAllFollowers(int amountAccountToSubscribe, TwitterAccount account) {
        List<CompletableFuture<Void>> allFollowers =
                IntStream.range(0, amountAccountToSubscribe)
                        .mapToObj(i -> followAccount(account))
                        .toList();

        CompletableFuture.allOf(allFollowers.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.printf("Account name: %s, Total followers: %s",
                        account.getUsername(), account.getFollowers())).join();

    }

    public void shuttingDownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error shutting down executor: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}
