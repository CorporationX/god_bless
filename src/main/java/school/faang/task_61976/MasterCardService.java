package school.faang.task_61976;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            handleInterruptedException(e);
            return 0;
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            handleInterruptedException(e);
            return 0;
        }
    }

    public void processPaymentAndAnalytics() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = pool.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        log.info("Аналитика отправлена: {}", analyticsResult);

        Integer paymentResult = null;
        try {
            paymentResult = paymentFuture.get();
        } catch (InterruptedException e) {
            handleInterruptedException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        log.info("Платеж выполнен: {}", paymentResult);

        pool.shutdown();
        try {
            if (!pool.awaitTermination(2, TimeUnit.MINUTES)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            handleInterruptedException(e);
        }
    }

    private void handleInterruptedException(InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}
