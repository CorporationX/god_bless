package school.faang.task_49969;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            System.err.println("Error: The execution of the CollectPayment method was interrupted.");
            System.err.println("Error message: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error in collectPayment", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.err.println("Error: The execution of the sendAnalytics method was interrupted");
            System.err.println("Error message: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error in sendAnalytics", e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.join();
            System.out.println("Analytics sent " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Payment processed " + paymentResult);
        } catch (Exception e) {
            System.err.println("An error occurred during execution:");
            System.err.println("Error message: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
