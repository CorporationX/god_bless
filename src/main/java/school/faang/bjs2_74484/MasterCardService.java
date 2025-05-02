package school.faang.bjs2_74484;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Data
public class MasterCardService {
    private static final int SlEEP_TIME_FOR_PAYMENTS = 2000;
    private static final int SlEEP_TIME_FOR_ANALYTICS = 3000;
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

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
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(
                this::sendAnalytics);
        try {
            Integer paymentResult = paymentFuture.get();
            Integer analyticsResult = analyticsFuture.join();
            System.out.printf("Analytics result: %d\n", analyticsResult);
            System.out.printf("Payment result: %d\n", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Execution exception or Interrupted");
        }
    }
}
