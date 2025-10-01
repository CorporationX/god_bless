package school.faang.bjs2_92645;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_DURATION_IN_MS = 10_000;
    private static final int ANALYTICS_DELAY_IN_MS = 1_000;

    private final ExecutorService ex = Executors.newFixedThreadPool(2);

    public static int collectPayment() {
        log.info("Starting payment collection process");
        try {
            Thread.sleep(PAYMENT_DURATION_IN_MS);
            log.info("Payment collection completed");
            return 500;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Payment collection interrupted", e);
        }
    }

    public static int sendAnalytics() {
        log.info("Start analytics sending");
        try {
            Thread.sleep(ANALYTICS_DELAY_IN_MS);
            log.info("Analytics sending completed");
            return 1_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Analytics send interrupted", e);
        }
    }

    public void doAll() throws InterruptedException, ExecutionException {
        try {
            Future<Integer> paymentFuture = ex.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsFuture =
                    CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

            int analyticsResult = analyticsFuture.get();
            log.info("Analytics result: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Payment result: {}", paymentResult);
        } finally {
            ex.shutdown();
        }
    }
}
