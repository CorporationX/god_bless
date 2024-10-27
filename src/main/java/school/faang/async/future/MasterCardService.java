package school.faang.async.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        final int TIMEOUT_PAYMENT = 1_000;

        try {
            Thread.sleep(TIMEOUT_PAYMENT);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        final int TIMEOUT_ANALYTICS = 10_000;

        try {
            Thread.sleep(TIMEOUT_ANALYTICS);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Analytics sent: " + analytics.join());
        try {
            if (analytics.isDone()) {
                System.out.println("Payment completed: " + payment.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
