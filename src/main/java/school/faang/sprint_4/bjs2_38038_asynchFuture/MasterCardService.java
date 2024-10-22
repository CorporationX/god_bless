package school.faang.sprint_4.bjs2_38038_asynchFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_COLLECT_TIME = 10_000;
    private static final int ANALYTICS_SEND_TIME = 1_000;

    private int collectPayment() {
        try {
            log.info("Collecting payment for {} seconds.", PAYMENT_COLLECT_TIME / 1000);
            Thread.sleep(PAYMENT_COLLECT_TIME);
            return PAYMENT_COLLECT_TIME;
        } catch (InterruptedException e) {
            log.error("An error occurred while collecting payment.", e);
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            log.info("Sending analytics for {} seconds.", ANALYTICS_SEND_TIME / 1000);
            Thread.sleep(ANALYTICS_SEND_TIME);
            return ANALYTICS_SEND_TIME;
        } catch (InterruptedException e) {
            log.error("An error occurred while sending analytics.", e);
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> payment = executor.submit(this::collectPayment);

        CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(result -> log.info("Analytics send: {}", result))
                .thenRun(() -> {
                    try {
                        log.info("Payment collected: {}", payment.get());
                    } catch (InterruptedException | ExecutionException e) {
                        log.error("An error occurred while waiting payment result");
                        throw new RuntimeException(e);
                    }
                });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Some operations didn't finished in time, shutting down now.");
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while shutting down executor.", e);
            throw new RuntimeException(e);
        }
    }
}
