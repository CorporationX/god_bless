package school.faang.async_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
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

    public void doAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            CompletableFuture<Integer> paymentFuture = CompletableFuture.supplyAsync(
                    MasterCardService::collectPayment, executor);
            CompletableFuture<Integer> analiticFuture = CompletableFuture.supplyAsync(
                    MasterCardService::sendAnalytics, executor);

            Integer analyticsResult = analiticFuture.join();
            Integer paymentResult = paymentFuture.get();

            System.out.println("Аналитика отправлена: " + analyticsResult);
            System.out.println("Платеж выполнен: " + paymentResult);
        } finally {
            executor.shutdown();
        }
    }
}