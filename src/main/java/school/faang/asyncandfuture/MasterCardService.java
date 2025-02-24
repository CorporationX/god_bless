package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int FIVE_SECONDS_IN_MS = 5_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
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
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        } finally {
            executor.shutdown();
        }

        try {
            if (!executor.awaitTermination(FIVE_SECONDS_IN_MS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("Thread shutdown now");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        }

    }
}
