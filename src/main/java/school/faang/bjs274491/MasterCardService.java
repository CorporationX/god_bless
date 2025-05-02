package school.faang.bjs274491;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_WAITING_TIME = 10_000;
    private static final int ANALYSING_WAITING_TIME = 1_000;

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            log.info("Analytics sent: {}", analyticsResult.get());
            log.info("Payment success: {}", paymentResult.get());
            executor.shutdown();
            if (!executor.awaitTermination(PAYMENT_WAITING_TIME, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted: {}", e.getMessage());
        } catch (ExecutionException e) {
            log.error("Execution error: {}", e.getMessage());
        }
    }

    private static int collectPayment() {
        try {
            log.info("Processing payment...");
            Thread.sleep(PAYMENT_WAITING_TIME);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while processing payment: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            log.info("Sending analytics...");
            Thread.sleep(ANALYSING_WAITING_TIME);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted while sending analytics: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
