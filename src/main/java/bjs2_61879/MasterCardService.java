package bjs2_61879;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    public static final int COLLECT_PAYMENT_WORK_TIME_MS = 10_000;
    public static final int SEND_ANALYTICS_WORK_TIME_MS = 1_000;
    public static final int WAIT_TERMINATION_TIMEOUT_SECONDS = 5;

    private static int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_WORK_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Ошибка в collectPayment: {}", e.getMessage(), e);
        }

        return 7_000;
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_WORK_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Ошибка в sendAnalytics: {}", e.getMessage(), e);
        }

        return 3_000;
    }

    public void doAll() {
        var executor = Executors.newSingleThreadExecutor();

        try {
            var collectPaymentTask = executor.submit(MasterCardService::collectPayment);

            CompletableFuture.supplyAsync(MasterCardService::sendAnalytics)
                    .thenAccept(result -> log.info("Аналитика отправлена: {}", result))
                    .join();

            var collectPaymentResult = collectPaymentTask.get();
            log.info("Платеж выполнен: {}", collectPaymentResult);

        } catch (Exception e) {
            log.error("Ошибка в doAll: {}", e.getMessage(), e);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(WAIT_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}
