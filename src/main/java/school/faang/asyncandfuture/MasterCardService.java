package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TIMEOUT_ONE_SECOND_IN_MS = 1_000;
    private static final int TIMEOUT_FIVE_SECONDS_IN_MS = 5_000;
    private static final int COLLECT_PAYMENT_NUMBER = 5_000;
    private static final int SEND_ANALYTICS_NUMBER = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TIMEOUT_FIVE_SECONDS_IN_MS);
            return COLLECT_PAYMENT_NUMBER;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(TIMEOUT_ONE_SECOND_IN_MS);
            return SEND_ANALYTICS_NUMBER;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    void doAll(ExecutorService executor) {
        CompletableFuture<Integer> sendAnalyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        try {
            int analyticsResult = sendAnalyticsFuture.join();
            log.info("Analytics is send: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Payment is send: {}", paymentResult);

            executor.shutdown();

            if (!executor.awaitTermination(TIMEOUT_FIVE_SECONDS_IN_MS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("Thread shutdown now");
            }

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        }
    }
}
