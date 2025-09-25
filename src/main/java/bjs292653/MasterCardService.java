package bjs292653;

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
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> collectPaymentResult = executorService.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytics);
            int analyticsResult = sendAnalyticsResult.join();
            System.out.println("Analytic report sent: " + analyticsResult);
            int paymentResult = collectPaymentResult.get();
            System.out.println("Payment is done: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
