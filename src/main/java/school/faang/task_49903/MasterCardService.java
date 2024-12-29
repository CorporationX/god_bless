package school.faang.task_49903;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int NUM_THREADS = 3;
    private static final long EXECUTOR_TIMEOUT_SECONDS = 11;

    private static final String INTERRUPTED_EXCEPTION_MESSAGE_FORMAT = "Поток %s был прерван";

    private static final long COLLECTING_PAYMENT_TIME_MILLIS = 10_000;
    private static final long SENDING_ANALYTICS_TIME_MILLIS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(COLLECTING_PAYMENT_TIME_MILLIS);
            return 10_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String message = String.format(INTERRUPTED_EXCEPTION_MESSAGE_FORMAT, Thread.currentThread().getName());
            log.error(message, e);
            throw new IllegalStateException(message, e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(SENDING_ANALYTICS_TIME_MILLIS);
            return 1_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String message = String.format(INTERRUPTED_EXCEPTION_MESSAGE_FORMAT, Thread.currentThread().getName());
            log.error(message, e);
            throw new IllegalStateException(message, e);
        }
    }


    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, executor);
        CompletableFuture<Integer> paymentResult = CompletableFuture.supplyAsync(
                MasterCardService::collectPayment, executor);

        analyticsResult.thenAccept(result -> log.info("Аналитика отправлена: {}", result))
                .exceptionally(ex -> {
                    log.error("Ошибка аналитики", ex);
                    return null;
                });
        paymentResult.thenAccept(result -> log.info("Платеж выполнен: {}", result))
                .exceptionally(ex -> {
                    log.error("Ошибка платежа", ex);
                    return null;
                });

        executor.shutdown();
        try {
            if (executor.awaitTermination(EXECUTOR_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.info("Задача выполнена успешно");
            } else {
                log.warn("Не удалось выполнить задачу за отведенное время");
            }
        } catch (InterruptedException e) {
            String message = String.format(INTERRUPTED_EXCEPTION_MESSAGE_FORMAT, Thread.currentThread().getName());
            log.error(message, e);
            throw new IllegalStateException(message, e);
        }
    }

}
