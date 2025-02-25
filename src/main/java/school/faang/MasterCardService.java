package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 1;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final int PAYMENT_PROCESSING_DELAY_MS = 10000;
    private static final int COLLECTING_PROCESSING_DELAY_MS = 10000;

    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_PROCESSING_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return 5000;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(COLLECTING_PROCESSING_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return 17000;
    }

    public void doAll() {
        Future<Integer> futurePayment = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        try {
            System.out.println("Analytics has been sent: " + futureAnalytics.get());
            System.out.println("Payment has been completed: " + futurePayment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error: {} in method \"doAll\"", e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
