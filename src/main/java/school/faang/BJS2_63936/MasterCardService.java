package school.faang.BJS2_63936;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_SUCCESS_AMOUNT = 5_000;
    private static final int ANALYTICS_SUCCESS_AMOUNT = 17_000;
    private static final int ERROR_VALUE = -1;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_SUCCESS_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Оплата не прошла ", e);
        }
        return ERROR_VALUE;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_SUCCESS_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Аналитика не вернулась ", e);
        }
        return ERROR_VALUE;
    }

    public void doAll() {
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics)
                .exceptionally(ex -> {
                    log.error("Ошибка при отправке аналитики", ex);
                    return ERROR_VALUE;
                })
                .thenApply(result -> {
                    log.info("Аналитика отправлена: {}", result);
                    return result;
                });

        CompletableFuture<Integer> paymentFuture = CompletableFuture.supplyAsync(this::collectPayment)
                .exceptionally(ex -> {
                    log.error("Ошибка при выполнении платежа", ex);
                    return ERROR_VALUE;
                })
                .thenApply(result -> {
                    log.info("Платеж выполнен: {}", result);
                    return result;
                });

        CompletableFuture.allOf(analyticsFuture, paymentFuture).join();
    }
}

