package school.faang.multithreading.async.bjs2_92975;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Slf4j
public class TwitterSubscriptionSystem {
    private static final int NUM_THREADS = 2;
    private static final int DELAY_TIME = 1000; // 1 секунда
    private static final int MAX_WAIT_TIME = 10; // 10 минут

    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static synchronized void addFollower(TwitterAccount account) {
        int newCount = account.followers().incrementAndGet();
        addDelay(DELAY_TIME);
        log.info("Добавлен новый подписчик к '{}', общее количество: {}",
                account.username(), newCount);
    }

    public static void followAccount(TwitterAccount account, List<Follower> followers) {
        List<CompletableFuture<Void>> futures = followers.stream()
                .map(follower ->
                        CompletableFuture.runAsync(() -> addFollower(account), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        gracefullyShutdown();
        log.info("Всего подписчиков: {}", account.followers().get());
    }

    public static void addDelay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
