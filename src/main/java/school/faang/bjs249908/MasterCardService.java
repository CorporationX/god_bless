package school.faang.bjs249908;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    static CompletableFuture<Integer> performTask(int sleepSeconds, int returnValue) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(sleepSeconds);
            return returnValue;
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return -1;
        });
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static CompletableFuture<Integer> collectPayment() {
        return performTask(10, 10_000);
    }

    static CompletableFuture<Integer> sendAnalytics() {
        return performTask(1, 1_000);
    }

    static int sendAnalyticsStatic() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        CompletableFuture<Integer> paymentFuture = collectPayment();
        CompletableFuture<Integer> analyticsFuture = sendAnalytics();
        paymentFuture.thenAccept(payment -> System.out.println("Analytics sent: " + payment));
        analyticsFuture.thenAccept(analytics -> System.out.println("Payment processed: " + analytics));

        CompletableFuture<Integer> analyticsFutureStatic =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalyticsStatic);
        analyticsFuture.thenAccept(analyticsStatic ->
                System.out.println("Analytics sent as lambda: " + analyticsStatic));

        CompletableFuture.allOf(paymentFuture, analyticsFuture, analyticsFutureStatic).join();
    }
}
