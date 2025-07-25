package school.faang.s_4_1_async_and_future;

import java.util.concurrent.CompletableFuture;

public class MasterCardService2 {
    public int collectPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 10000;
    }

    public String sendAnalytics() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "analytics: 58 99 05";
    }

    public void doAll() {
        CompletableFuture<Void> paymentFuture = CompletableFuture.supplyAsync(this::collectPayment)
                .thenAccept(payment -> System.out.println("Payment received: " + payment));
        CompletableFuture<Void> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(analytics -> System.out.println("Analytics was sent: " + analytics));
        CompletableFuture.allOf(paymentFuture, analyticsFuture).join();
    }
}
