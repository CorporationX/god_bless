package school.faang.bjs2_74484;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int SlEEP_TIME_FOR_PAYMENTS = 2000;
    private static final int SlEEP_TIME_FOR_ANALYTICS = 10000;
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public int collectPayment() {
        try {
            Thread.sleep(SlEEP_TIME_FOR_PAYMENTS);
            return 1000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Iterrupted");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(SlEEP_TIME_FOR_ANALYTICS);
            return 42;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Iterrupted");
        }
    }

    public void doAll() {
        Future<Integer> paymentFuture = singleThreadExecutor.submit(this::collectPayment);
        try {
            Integer result = paymentFuture.get();
            System.out.printf("Payment result: %d\n", result);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Execution exception or Interrupted");
        }
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(
                this::sendAnalytics
        );
        Integer result = analyticsFuture.join();
        System.out.printf("Analytics result: %d\n", result);
        singleThreadExecutor.shutdown();
        try {
            if (!singleThreadExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
                singleThreadExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted");
        }
    }
}
