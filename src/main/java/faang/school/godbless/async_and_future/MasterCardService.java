package faang.school.godbless.async_and_future;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.*;

@AllArgsConstructor
@Getter
@Setter
public class MasterCardService {
    private final int payment;
    private final int analytics;

    public static int collectPayment() {
        //System.out.println("Money sent " + payment);
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        try {


            CompletableFuture<Void> resultFutures = CompletableFuture.allOf((CompletableFuture<?>) paymentFuture, analyticsFuture);
            resultFutures.join();
            int paymentResult = paymentFuture.get();
            System.out.println("Payment result: " + paymentResult);

            int analyticsResult = analyticsFuture.get();
            System.out.println("Analytics result: " + analyticsResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
