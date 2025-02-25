package school.faang.BJS2_63936;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Оплата не прошла ", e);
        }
        return 5_000;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Аналитика не вернулась ", e);
        }
        return 0;
    }

    public void doAll() {
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics)
                .handle((result, ex) -> {
                    if (ex != null) {
                        log.error("Ошибка при отправке аналитики: ", ex);
                        return 0;
                    }
                    log.info("Аналитика отправлена: {}", result);
                    return result;
                });

        CompletableFuture<Integer> paymentFuture = CompletableFuture.supplyAsync(this::collectPayment)
                .handle((result, ex) -> {
                    if (ex != null) {
                        log.error("Ошибка при отправке платежа: ", ex);
                        return 0;
                    }
                    log.info("Платеж выполнен: {}", result);
                    return result;
                });

        CompletableFuture.allOf(analyticsFuture, paymentFuture).join();
    }
}

