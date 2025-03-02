package asyncfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int COLLECTING_PAYMENT_TIME_MS = 10_000;
    private static final int SENDING_ANALYTICS_TIME_MS = 1_000;
    private static final int PAYMENT_RETURN = 5_000;
    private static final int ANALYTICS_RETURN = 17_000;

    static CompletableFuture<Integer> collectPayment() {
        log.info("Scheduled payment processing with a delay of {} ms", COLLECTING_PAYMENT_TIME_MS);
        return CompletableFuture.supplyAsync(() -> {
            log.info("Starting payment processing...");
            return PAYMENT_RETURN;
        }, CompletableFuture.delayedExecutor(COLLECTING_PAYMENT_TIME_MS, TimeUnit.MILLISECONDS));
    }

    static CompletableFuture<Integer> sendAnalytics() {
        log.info("Scheduled analytics sending with a delay of {} ms", SENDING_ANALYTICS_TIME_MS);
        return CompletableFuture.supplyAsync(() -> {
            log.info("Starting analytics sending...");
            return ANALYTICS_RETURN;
        }, CompletableFuture.delayedExecutor(SENDING_ANALYTICS_TIME_MS, TimeUnit.MILLISECONDS));
    }

    public void doAll() {
        CompletableFuture<Integer> paymentFuture = collectPayment();
        CompletableFuture<Integer> analyticsFuture = sendAnalytics();

        paymentFuture.thenCombine(analyticsFuture, (paymentResult, analyticsResult) -> {
            log.info("Payment processed: {}", paymentResult);
            log.info("Analytics sent: {}", analyticsResult);
            return null;
        }).exceptionally(e -> {
            log.error("Exception occurred during processing", e);
            return null;
        }).join();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
