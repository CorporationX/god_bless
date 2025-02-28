package school.faang.BJS2_61937;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    public static final int PAYMENT_AMOUNT = 5_000;
    public static final int ANALYTICS_AMOUNT = 17_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService es = Executors.newSingleThreadScheduledExecutor();

        log.info("Запуск операции по сбору платежа...");
        Future<Integer> futureResult = es.submit(MasterCardService::collectPayment);

        log.info("Запуск операции по отправке аналитики...");
        CompletableFuture<Integer> completableResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        log.info("Аналитика отправлена: {}", completableResult.join());

        try {
            log.info("Результат платежа: {}", futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка выполнения операций: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            es.shutdown();
        }
    }
}
