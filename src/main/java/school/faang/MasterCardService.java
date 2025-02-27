package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int MAX_THREADS = 3;
    private static final int SLEEP_TIME = 2000;

    public static void main(String[] args) {

        doAll();
    }

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Ошибка при выполнении операции");
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);
        new Thread(() -> {
            try {
                while (!paymentFuture.isDone()) {
                    log.info("Выполняю операцию");
                    Thread.sleep(SLEEP_TIME);
                }
                int payment = paymentFuture.get();
                log.info("Оплата получена: {}" + payment);
            } catch (InterruptedException | ExecutionException e) {
                log.error("Ошибка при выполнении операции: " + e);
            }
        }).start();

        analyticsFuture.thenAccept(result -> log.info("Аналитика оптравлена: " + result));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
