package asyncandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analytics = analyticsFuture.get();
        System.out.println("Analytics sent: " + analytics);

        Integer payment = paymentFuture.get();
        System.out.println("Payment collected: " + payment);

        executorService.shutdown();
        System.out.println("All tasks completed.");
    }
}
