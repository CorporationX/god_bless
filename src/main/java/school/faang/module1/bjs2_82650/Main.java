package school.faang.module1.bjs2_82650;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int POOL_SIZE = 5;
    private static final int NUMBER_OF_SUBSCRIPTIONS = 100;
    private static final int AWAIT_TERMINATION_TIMEOUT_SEC = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("dasha");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(executor);

        List<CompletableFuture<Void>> futures = IntStream.range(0, NUMBER_OF_SUBSCRIPTIONS)
                .mapToObj(subscriptionIndex -> system.followAccount(account))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("{} : {} подписчиков", account.getUsername(), account.getFollowers());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                log.warn("Задачи не завершились вовремя. Принудительная остановка");
                executor.shutdownNow();
            } else {
                log.info("Все задачи завершились");
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков было прервано", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}