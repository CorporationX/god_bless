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
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT = 5_000;
    private static final int ANALYSIS = 17_000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT;
        } catch (InterruptedException e) {
            threadExceptionHandler(e);
        }
        return 0;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYSIS;
        } catch (InterruptedException e) {
            threadExceptionHandler(e);
        }
        return 0;
    }

    public void doAll() {
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> payment = executor.submit(this::collectPayment);
            CompletableFuture<Integer> analysis = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
            Integer analyticsResult = analysis.join();
            log.info("Аналитика отправлена: {}", analyticsResult);
            Integer paymentResult = payment.get();
            log.info("Платеж выполнен: {}", paymentResult);
            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (Exception e) {
            threadExceptionHandler(e);
            log.info("Произошла ошибка: {}", e.getMessage());
        }
    }

    private void threadExceptionHandler(Exception e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}
