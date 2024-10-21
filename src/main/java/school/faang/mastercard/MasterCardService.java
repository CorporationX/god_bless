package school.faang.mastercard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static final int NUM_THREADS = 2;

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer> paymentResult = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);
        int analytics = analyticsResult.join();
        System.out.println("Analytics sent: " + analytics);
        int payment = paymentResult.get();
        System.out.println("Payment completed: " + payment);
        executor.shutdown();
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
