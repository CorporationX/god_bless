package school.faang.asynchronity_future;

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
    private final ExecutorService executor;

    public MasterCardService(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public static int collectPayment() {
        log.info("collectPayment is running on: " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            log.error("Thread was interrupted during collectPayment", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Payment collection process was interrupted", e);
        }
    }

    public static int sendAnalytics() {
        log.info("sendAnalytics is running on: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            log.error("Thread was interrupted during sendAnalytics", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sending analytics process was interrupted", e);
        }
    }

    public void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        analyticsFuture.thenAccept(analyticsResult -> log.info("Analytics has been sent: " + analyticsResult));
        try {
            Integer paymentResult = paymentFuture.get(12, TimeUnit.SECONDS);
            log.info("Payment has been completed: " + paymentResult);
        } catch (InterruptedException e) {
            log.error("Payment task was interrupted", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Payment process was interrupted", e);
        } catch (ExecutionException e) {
            log.error("Exception occurred while executing the payment task", e);
            throw new RuntimeException("Payment task execution failed", e);
        } catch (TimeoutException e) {
            log.error("Payment task timed out after waiting for 12 seconds", e);
            throw new RuntimeException("Payment process timed out", e);
        } finally {
            shutDownExecutor();
        }
    }

    private void shutDownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specific time. Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown was interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}