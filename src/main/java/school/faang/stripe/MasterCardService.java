package school.faang.stripe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MasterCardService implements AutoCloseable {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException(
                    String.format("Thread %s interrupted", Thread.currentThread().getName()), e
            );
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException(
                    String.format("Thread %s interrupted", Thread.currentThread().getName()), e
            );
        }
    }

    public void doAll() {
        Future<Integer> future = executor.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        log.info("Complete tasks...");
        try {
            log.info("Analytics result: {}", completableFuture.get(1, TimeUnit.MINUTES));
            log.info("Payment result: {}", future.get(1, TimeUnit.MINUTES));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException("Something went wrong in async computation", e);
        }
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
