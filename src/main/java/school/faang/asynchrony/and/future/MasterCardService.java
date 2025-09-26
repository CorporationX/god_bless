package school.faang.asynchrony.and.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int VALUE_FOR_PAYMENT = 5_000;
    private static final int VALUE_FOR_ANALYTICS = 10_000;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return VALUE_FOR_PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return VALUE_FOR_ANALYTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            Integer paymentResult = paymentFuture.get();
            Integer analyticsResult = analyticsFuture.join();

            log.info("[?] Платёж выполнен - {}.", paymentResult);
            log.info("[?] Результаты аналитики готовы - {}.", analyticsResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } finally {
            service.shutdown();
        }
    }
}
