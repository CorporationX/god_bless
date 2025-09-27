package school.faang.bjs2_92575;

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
    private static final int PAYMENT_COUNT = 5_000;
    private static final int ANALYTICS_COUNT = 17_000;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_COUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_COUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll(ExecutorService executor) {

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = analyticsFuture.join();
            log.info("Аналитика отправлена: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван: {}", e.getMessage());
        } catch (ExecutionException e) {
            log.error("Ошибка выполнения платежа: {}", e.getCause().getMessage());
        } finally {
            executor.shutdown();
        }
    }
}