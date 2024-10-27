package school.faang.BJS2_39059;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int THREAD_NUMBER = 5;
    private static int followersNumber = 200;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Mr.Beast");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);

        CompletableFuture<?>[] followers = new CompletableFuture[followersNumber];

        for (int i = 0; i < followersNumber; i++) {
            followers[i] = CompletableFuture.runAsync(() ->
                    system.followAccount(account), executor
            );
        }

        CompletableFuture<Void> follower = CompletableFuture.allOf(followers);

        follower.thenRun(() -> {
            Arrays.stream(followers).forEach(f -> {
                try {
                    f.get();
                } catch (Exception e) {
                    logger.error("Ошибка при завершении асинхронной задачи", e);
                }
            });
            System.out.println("Количество подписчиков: " + account.getFollowers());
        }).join();

        executor.shutdown();

        try {
            if (!executor.isShutdown()) {
                logger.warn("Принудительное завершение потоков");
                executor.shutdownNow();
            }
        } catch (Exception e) {
            logger.error("Ошибка при завершении потоков", e);

        }
    }
}

