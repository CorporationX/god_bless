package school.faang.bjs2_82355;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private ExecutorService threadPool;

    public MasterCardService(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public static String collectPayment() {
        log.info("Начата транзакция по оплате...");
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return "Оплата прошла успешно";

        } catch (InterruptedException e) {
            log.error("Поток был прерван. Оплата не прошла", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван. Оплата не прошла", e);
        }
    }

    public static String sendAnalytics() {
        log.info("Отправка аналитики...");
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return "Аналитика успешно отправлена";

        } catch (InterruptedException e) {
            log.error("Поток был прерван. Аналитика не отправлена", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван. Аналитика не отправлена", e);
        }
    }

    public void processPaymentWithAnalytics() {
        Future<String> collectPaymentResult = threadPool.submit(MasterCardService::collectPayment);
        CompletableFuture<String> sendAnalyticsResult =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, threadPool);

        try {
            log.info("Результат отправки аналитики: {}", sendAnalyticsResult.join());
            log.info("Результат отправки оплаты: {}", collectPaymentResult.get());

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Не удалось получить результат оплаты", e);
        }
    }
}
