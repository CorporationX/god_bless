package school.faang.bjs274491;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_WAITING_TIME = 10_000;
    private static final int ANALYSING_WAITING_TIME = 1_000;

    public void doAll() {
        CompletableFuture<Boolean> paymentResult = CompletableFuture.supplyAsync(MasterCardService::collectPayment);
        CompletableFuture<Boolean> analyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            log.info("Analytics sent: {}", analyticsResult.get());
            log.info("Payment success: {}", paymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted: {}", e.getMessage());
        }
    }

    private static boolean collectPayment() {
        try {
            Thread.sleep(PAYMENT_WAITING_TIME);
            log.info("Processing payment...");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while processing payment: {}", e.getMessage());
            return false;
        }
    }

    private static boolean sendAnalytics() {
        try {
            Thread.sleep(ANALYSING_WAITING_TIME);
            log.info("Sending analytics...");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while sending analytics: {}", e.getMessage());
            return false;
        }
    }
}
