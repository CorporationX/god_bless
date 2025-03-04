package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int TEN_SECONDS = 10;
    private static final int TREAD_COUNTS = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(TREAD_COUNTS);

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 1;
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 1;
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    public void doAll() {
        Future<Integer> payment = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        System.out.println("Аналитика: " + analyticsFuture.join());

        try {
            System.out.println("Оплата: " + payment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Thread execution was interrupted", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread execution was interrupted", e);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(TEN_SECONDS, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}