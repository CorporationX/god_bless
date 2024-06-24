package faang.school.godbless.multithreading.asynchronousandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static int collectPayment() {
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
    public void doAll() throws InterruptedException {
        var threadPool = Executors.newFixedThreadPool(2);

        var paymentCompletableFuture = CompletableFuture.supplyAsync(MasterCardService::collectPayment, threadPool);
        var analyticsCompletableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, threadPool);

        var analyticsResult = analyticsCompletableFuture.join();
        System.out.printf("Analytics: %d\n", analyticsResult);

        var paymentResult = paymentCompletableFuture.join();
        System.out.printf("Payment: %d\n", paymentResult);

        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
