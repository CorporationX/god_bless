package school.faang.bjs2_82355;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final long POOL_AWAIT_TIMEOUT = 20;

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

    public void doAll() {
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        Future<String> collectPaymentResult = fixedPool.submit(MasterCardService::collectPayment);
        CompletableFuture<String> sendAnalyticsResult =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, fixedPool);

        try {
            log.info("Результат отправки аналитики: {}", sendAnalyticsResult.join());
            log.info("Результат отправки оплаты: {}", collectPaymentResult.get());

            fixedPool.shutdown();

            while (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершены");
                fixedPool.shutdownNow();
            }

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            fixedPool.shutdownNow();
        } catch (ExecutionException e) {
            log.error("Не удалось получить результат оплаты", e);
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            log.error("Ошибка выполнения задачи: ", cause);
        }
        log.info("Все задачи завершены");
    }
}
