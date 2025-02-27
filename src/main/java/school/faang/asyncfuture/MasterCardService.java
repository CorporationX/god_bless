package school.faang.asyncfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int THREAD_NUMS = 1;
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMS);
    private final int randomPayment = new Random().nextInt(0, 5000);
    private final int randomAnalytics = new Random().nextInt(0, 5000);

    public int collectPayment() {
        log.debug("Payment thread started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted", e);
        }
        return randomPayment;
    }

    public int sendAnalytics() {
        log.debug("Analytics thread started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted", e);
        }
        return randomAnalytics;
    }

    public void doAll() {
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Void> analyticsCompletableFuture = CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(result -> log.debug("analytics - {}", result));
        while (!analyticsCompletableFuture.isDone()) {
            log.debug("We are waiting for analytics results");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error("The thread was interrupted", e);
            }
        }
        while (!paymentFuture.isDone()) {
            log.debug("Now we are waiting for payment results");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("The thread was interrupted", e);
            }
        }
        try {
            log.debug("Payment - {}", paymentFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            log.error("The thread is interrupted", e);
            executor.shutdownNow();
        }
    }
}
