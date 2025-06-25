package school.faang.bjs2_82407;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    private static final int THREAD_POOL_SIZE = 2;
    private static final int PAYMENT_DELAY_MS = 10_000;
    private static final int ANALYTICS_DELAY_MS = 1_000;
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_AMOUNT = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Payment collection interrupted", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY_MS);
            return ANALYTICS_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Analytics sending interrupted", e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsFuture = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytics, executor);

            int analyticsResult = analyticsFuture.get();
            log.info("Analytics result: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Payment result: {}", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Execution failed", e);
        } finally {
            executor.shutdown();
        }
    }
}
