package faang.school.godbless.fourthsprint.asyncandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PaymentProcessor {
    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        int analyticsResult = analyticsFuture.join();
        System.out.println("Analytics result: " + analyticsResult);

        try {
            int paymentResult = paymentFuture.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw new RuntimeException("Error during execution", cause);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
    }
}
