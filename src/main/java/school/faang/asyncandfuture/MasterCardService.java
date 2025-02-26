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
    private static final int THREADS_COUNT = 2;

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    private void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        analyticsFuture.thenAccept(result -> log.info("Аналитика отправлена: {}", result)).join();
        try {
            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
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
            return 5000;
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    private int sendAnalytics() {
        try {
            log.info("Analytics process in progress");
            Thread.sleep(ANALYTICS_TIME);
            return 17000;
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
