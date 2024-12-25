package school.faang.task_49882;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    public static final int TIMEOUT = 30;
    public static final int TIME_ANALYTICS_SLEEP_MS = 2000;
    public static final int TIME_PAYMENT_SLEEP_MS = 6000;

    public static int collectPayment() {
        try {
            Thread.sleep(TIME_PAYMENT_SLEEP_MS);
            log.info("Обработка платежа ");
            return 6_000;
        } catch (InterruptedException e) {
            log.error("Ошибка при проведении платежа", e);
            throw new RuntimeException("Ошибка при отправке платежа ", e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(TIME_ANALYTICS_SLEEP_MS);
            log.info("Сбор и отправка аналитики");
            return 2_000;
        } catch (InterruptedException e) {
            log.error("Ошибка при отправке аналитики", e);
            throw new RuntimeException("Ошибка при отправке аналитики ", e);

        }
    }

    public void doAll() {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executors.submit(() -> MasterCardService.collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(() -> MasterCardService.sendAnalytics());

        try {
            Integer analyticsResult = analyticsFuture.join();
            log.info("Аналитика отправлена: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executors.shutdown();
            try {
                if (!executors.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                    log.error("Время, отведенное на завершение программы закончилось");
                }
            } catch (InterruptedException e) {
                log.error("Main поток был прерван во время ожидания завершения {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}