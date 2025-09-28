package bjs2_92593;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS = 17_000;
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при обработке платежа", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при отправке аналитики", e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

            CompletableFuture<Integer> analyticsFuture =
                    CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

            Integer analyticsResult = analyticsFuture.join();
            System.out.printf("Аналитика отправлена: %d%n", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            System.out.printf("Платеж выполнен: %d ₸%n", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Ошибка при выполнении операций", e);
        } finally {
            executor.shutdown();
        }
    }
}