package school.faang.bjs274685;

import java.util.concurrent.*;
import java.util.concurrent.ExecutionException;

public class MasterCardService {
    private static final int PAYMENT_DELAY = 10_000;
    private static final int ANALYTICS_DELAY = 1000;
    private static final int WAIT_TIME = 5;

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> paymentFuture = executor.submit(() -> {
            System.out.printf("Collecting payment starting (%s)\n", Thread.currentThread().getName());
            return collectPayment();
        });
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> {
            System.out.printf("Sending analytics starting (%s)\n", Thread.currentThread().getName());
            return sendAnalytics();
        });
        analyticsFuture.thenAccept(analytics ->
                System.out.printf("Analytics sent: %d\n", analytics));
        int payment = paymentFuture.get();
        System.out.println("Payment successful: " + payment);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAIT_TIME, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (
                InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
