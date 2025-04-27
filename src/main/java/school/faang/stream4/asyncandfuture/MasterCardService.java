package school.faang.stream4.asyncandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            System.out.println("Получен запрос на оплату. Обрабатываю...");
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        while (!collectPaymentResult.isDone() || !sendAnalyticsResult.isDone()) {
            try {
                Thread.sleep(ONE_SECOND_IN_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("bamboleo!");
        }
        try {
            System.out.printf("Платеж выполнен: %d\n", collectPaymentResult.get());
            System.out.printf("Аналитика отправлена: %d\n", sendAnalyticsResult.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}
