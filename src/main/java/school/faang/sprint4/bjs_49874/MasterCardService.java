package school.faang.sprint4.bjs_49874;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;

    @SneakyThrows
    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticResult = CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            log.info("Payment processing...");
            paymentResult.get();
            analyticResult.join();
            log.info("Analytics have been sent");
            executorService.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            log.error("Processing interrupted");
            executorService.shutdownNow();
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(PAYMENT_TIME);
            return PAYMENT_TIME;
        } catch (InterruptedException e) {
            log.error("Payment was cancelled");
            return 0;
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_TIME);
            return ANALYTICS_TIME;
        } catch (InterruptedException e) {
            log.error("Analytics sending is cancelled");
            return 0;
        }
    }
}
