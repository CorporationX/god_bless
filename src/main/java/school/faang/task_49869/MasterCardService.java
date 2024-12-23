package school.faang.task_49869;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class MasterCardService {

    private static final int PAYMENT_DELAY_MS = 10_000;
    private static final int ANALYTICS_DELAY_MS = 1_000;

    public void doAll() {
        CompletableFuture<Integer> paymentFuture = CompletableFuture.supplyAsync(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        analyticsFuture.thenAccept(result -> log.info("Аналитика отправлена: {}", result)).join();

        paymentFuture.thenAccept(result -> log.info("Платеж выполнен: {}", result)).join();
    }

    private int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY_MS);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка в collectPayment: {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY_MS);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Ошибка в sendAnalytics: {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}