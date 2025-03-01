package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;
    private static final int PAYMENT_AMOUNT = 5000;
    private static final int ANALYTICS_RESULT = 17000;
    private static final int THREADS_COUNT = 2;

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    private void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        analyticsFuture.thenAccept(result -> log.info("Analytics sent: {}", result)).join();
        try {
            int paymentResult = paymentFuture.get();
            log.info("Payment completed: {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private int collectPayment() {
        try {
            log.info("Payment process in progress");
            Thread.sleep(PAYMENT_TIME);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            log.error("Thread interrupted {}", e.getMessage(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    private int sendAnalytics() {
        try {
            log.info("Analytics process in progress");
            Thread.sleep(ANALYTICS_TIME);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            log.error("Thread interrupted {}", e.getMessage(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
