package school.faang.future;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.future.exception.CollectPaymentException;
import school.faang.future.exception.SendAnalyticsException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Danil Pudovkin
 * @since 24.06.2025
 */
@Slf4j
@NoArgsConstructor
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public void doAll() {
        var sendAnalyticsFuture = CompletableFuture
                .supplyAsync(this::sendAnalytics)
                .whenComplete((analytics, ex) -> log.info("Аналитика отправлена: {}", analytics));
        var collectPaymentFuture = CompletableFuture
                .supplyAsync(this::collectPayment)
                .whenComplete((result, ex) -> log.info("Платеж выполнен: {}", result));
        var composedFuture = sendAnalyticsFuture
                .thenCompose(result -> collectPaymentFuture);
        try {
            composedFuture.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
        } catch (ExecutionException e) {
            log.error("Ошибка исполнения", e);
        }
    }

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CollectPaymentException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SendAnalyticsException(e);
        }
    }
}
