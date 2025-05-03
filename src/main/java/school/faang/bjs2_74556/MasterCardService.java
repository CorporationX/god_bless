package school.faang.bjs2_74556;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static final int DUMMY_PAYMENT_DURATION_MS = 10000;
    public static final int DUMMY_ANALYTICS_DURATION_MS = 1000;

    public int collectPayment() {
        try {
            Thread.sleep(DUMMY_PAYMENT_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        }
        return 100500;
    }

    public boolean sendAnalytics() {
        try {
            Thread.sleep(DUMMY_ANALYTICS_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return true;
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);

        CompletableFuture<Boolean> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        System.out.printf("Analytics send: %s%n", analyticsFuture.join());
        try {
            System.out.printf("Payment complete: %s%n", paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Payment error: %s%n", e);
        } finally {
            executor.shutdown();
        }
    }
}
