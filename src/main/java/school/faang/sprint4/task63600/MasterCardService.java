package school.faang.sprint4.task63600;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MasterCardService {
    private static final int SLEEP_TIME_1 = 10_000;
    private static final int SLEEP_TIME_2 = 1_000;
    private static final int NUM_THREADS = 2;
    private static final int TIMEOUT_1 = 10;
    private static final int TIMEOUT_2 = 20;
    private static final int PAYMENT = 5_000;
    private static final int ANALYTICS = 17_000;

    public int collectPayment() {
        try {
            Thread.sleep(SLEEP_TIME_1);
            return PAYMENT;
        } catch (InterruptedException e) {
            long interruptedTime = System.currentTimeMillis();
            Thread.currentThread().interrupt();
            log.warn("[{}] [{}] was interrupted", interruptedTime, Thread.currentThread().getName());
            throw new RuntimeException(Thread.currentThread().getName() + "was interrupted");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(SLEEP_TIME_2);
            return ANALYTICS;
        } catch (InterruptedException e) {
            long interruptedTime = System.currentTimeMillis();
            Thread.currentThread().interrupt();
            log.warn("[{}] [{}] was interrupted", interruptedTime, Thread.currentThread().getName());
            throw new RuntimeException(Thread.currentThread().getName() + "was interrupted");
        }
    }

    public void processPaymentAndAnalytics() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer> payment = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);
        try {
            System.out.printf("\nThe analytics was sent: %d", analytics.get(TIMEOUT_1, TimeUnit.SECONDS));
            System.out.printf("\nThe payment was executed: %d", payment.get(TIMEOUT_1, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(TIMEOUT_2, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
