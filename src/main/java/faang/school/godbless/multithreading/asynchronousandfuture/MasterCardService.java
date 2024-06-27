package faang.school.godbless.multithreading.asynchronousandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int COLLECT_PAYMENT_TIME = 10_000;
    private static final int SEND_ANALYTICS_TIME = 1_000;
    public static int collectPayment() {
        return sleep(COLLECT_PAYMENT_TIME);
    }
    public static int sendAnalytics() {
       return sleep(SEND_ANALYTICS_TIME);
    }

    private static int sleep(int sleepTime){
        try {
            Thread.sleep(sleepTime);
            return sleepTime;
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
