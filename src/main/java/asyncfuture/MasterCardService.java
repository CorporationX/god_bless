package asyncfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int PROCESSING_TIME_MS = 10_000;

    public int collectPayment() {
        try {
            Thread.sleep(PROCESSING_TIME_MS);
            return 10_000;
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(PROCESSING_TIME_MS);
            return 1_000;
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentResult = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            System.out.printf("Аналитика отправлена: %d \n", sendAnalyticsResult.get());
            System.out.printf("Платеж выполнен: %d \n", collectPaymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalArgumentException("Ошибка при получении результата аналитики или платежа.");
        }

        executorService.shutdown();
    }
}
