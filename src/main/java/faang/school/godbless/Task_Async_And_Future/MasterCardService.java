package faang.school.godbless.Task_Async_And_Future;

import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
public class MasterCardService {

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futurePayment = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsData = CompletableFuture.supplyAsync(() -> sendAnalytics());
        System.out.println("Sending the data...");
        int sentData = analyticsData.get();
        System.out.println("The data has been sent: " + sentData);
        System.out.println("Receiving payment...");
        int receivedPayment = futurePayment.get();
        System.out.println("The payment has been received: " + receivedPayment);
        executor.shutdown();
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Payment hasn't been sent");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Analytics hasn't been sent");
        }
    }
}
