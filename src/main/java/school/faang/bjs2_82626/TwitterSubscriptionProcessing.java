package school.faang.bjs2_82626;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionProcessing {
    private static final long POOL_AWAIT_TIMEOUT = 20;
    private static final long FOLLOWERS_COUNT = 200_000;

    private static ExecutorService fixedPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(fixedPool);
        TwitterAccount account = new TwitterAccount("Me");

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Количество подписчиков {}: {}", account.getUsername(), account.getFollowers().get());

        fixedPool.shutdown();
        try {
            if (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван");
            fixedPool.shutdownNow();
        }
        log.info("Все задачи завершены");
    }
}
