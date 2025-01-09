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
    private static final int PAYMENT_TIME = 2500;
    private static final int ANALYTICS_TIME = 3000;

    @SneakyThrows
    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(analyticData -> {
                    log.info("Analytics {} have been sent", analyticData);

                    Future<Integer> paymentResult = executorService.submit(this::collectPayment);
                    try {
                        log.info("Payment processing...");
                        log.info("Payment of {} completed", paymentResult.get());
                    } catch (ExecutionException | InterruptedException e) {
                        log.error("Processing interrupted");
                    } finally {
                        executorService.shutdown();
                    }
                }).get();
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
