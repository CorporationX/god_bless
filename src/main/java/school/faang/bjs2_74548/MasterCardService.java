package school.faang.bjs2_74548;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics,
                executor
        );
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Analytics submitted: " + analyticsResult);

        try {
            Integer paymentResult = paymentFuture.get();
            System.out.println("Payment done: " + paymentResult);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Payment collection was interrupted.");
        } catch (ExecutionException e) {
            System.err.println("Error during payment collection: " + e.getCause());
        }

    }
}
