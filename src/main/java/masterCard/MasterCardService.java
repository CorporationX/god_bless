package masterCard;

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

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            log.error("Ошибка во время обработки платежа", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            log.error("Ошибка во время отправки аналитики", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.get();
            log.info("Аналитика отправлена: {}", analyticsResult);
            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка при обработке платежа или аналитики", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при выполнении платежа или отправке аналитики", e);
        } finally {
            executor.shutdown();
        }
    }
}
