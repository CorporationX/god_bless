package school.faang.asin_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
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
        Future<Integer> result = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> resultTwo = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = resultTwo.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult;
        try {
            paymentResult = result.get();
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Платеж выполнен: " + paymentResult);
    }
}
