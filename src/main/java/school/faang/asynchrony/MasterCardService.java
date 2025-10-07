package school.faang.asynchrony;

import lombok.extern.slf4j.Slf4j;

/**
 * Проект: god_bless
 * Класс MasterCardService
 * Автор: Vital
 */

@Slf4j
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static Integer collectPayment() {
        try {
            log.info("Начало обработки платежа...");
            Thread.sleep(TEN_SECONDS_IN_MS);
            int payment = 5_000;
            log.info("Платеж успешно обработан: {}", payment);
            return payment;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Процесс оплаты прерван", e);
            throw new RuntimeException(e);
        }
    }

    public static Integer sendAnalytics() {
        try {
            log.info("Начало отправки аналитики...");
            Thread.sleep(ONE_SECOND_IN_MS);
            int analytics = 17_000;
            log.info("Аналитика успешно отправлена: {}", analytics);
            return analytics;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Отправка аналитики прервана", e);
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        var executor = java.util.concurrent.Executors.newSingleThreadExecutor();
        try {
            java.util.concurrent.Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

            java.util.concurrent.CompletableFuture<Integer> analyticsFuture =
                    java.util.concurrent.CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

            Integer analyticsResult = analyticsFuture.join();
            log.info("Аналитика отправлена: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (Exception e) {
            log.error("Ошибка при выполнении операций", e);
        } finally {
            executor.shutdown();
        }
    }
}