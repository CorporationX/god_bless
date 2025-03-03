package school.faang.task_62070;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

@Slf4j
public class MasterCardService {

    private static final int PAYMENT_DELAY_MS = 10_000;
    private static final int ANALYTICS_DELAY_MS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY_MS);
            return PAYMENT_DELAY_MS;
        } catch (InterruptedException e) {
            log.error("Ошибка во время выполнения collectPayment", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY_MS);
            return ANALYTICS_DELAY_MS;
        } catch (InterruptedException e) {
            log.error("Ошибка во время выполнения sendAnalytics", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.join();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка во время выполнения doAll", e);
        } finally {
            executor.shutdown();
        }
    }
}
