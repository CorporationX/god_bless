package school.faang.BJS239060;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int THREADS = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public synchronized void addFollower(TwitterAccount account) {
            log.info("Увеличиваем количество подписчиков, текущее количество " + account.getFollowers());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error("Что то пошло не так с добавлением подписчиков ", e);
            }
            account.getFollowers().incrementAndGet();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account), executorService)
                .thenRun(() -> log.info("Общее количество подписчиков: " + account.getFollowers()))
                .join();
    }

    public void shutDown() {
        executorService.shutdown();
    }
}
