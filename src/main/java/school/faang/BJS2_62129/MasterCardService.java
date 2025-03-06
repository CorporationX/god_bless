package school.faang.BJS2_62129;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int THREAD_POOL_SIZE = 2;
    private static final int COLLECTED_PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_RESULT_VALUE = 17_000;
    private static final Logger LOGGER = LoggerFactory.getLogger(MasterCardService.class);

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return COLLECTED_PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Поток был прерван", e);
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void processPaymentAndAnalytics() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        try {
            Integer paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (Exception e) {
            LOGGER.error("Exception: {}\n", e.getMessage());
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
