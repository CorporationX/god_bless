package school.faang.BJS239060;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int THREADS = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private final AtomicInteger followers = new AtomicInteger(0);

    public synchronized void addFollower(TwitterAccount account) {
            log.info("Увеличиваем количество подписчиков, текущее количество " + account.getFollowers());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int total = account.getFollowers();
            followers.addAndGet(total);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture<TwitterAccount> future = CompletableFuture.supplyAsync(() -> account, executorService);
        future.thenRunAsync(() -> addFollower(account), executorService)
                .thenRun(() -> log.info("Общее количество подписчиков: " + followers))
                .join();
    }

    public void shutDown() {
        executorService.shutdown();
    }
}
