package faang.school.godbless.sprint4.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        doALl();
    }

    static void doALl() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        executor.shutdown();
        try {
            int analytics = analyticsFuture.get();
            System.out.println("Analytics sent: " + analytics);
            int payment = paymentFuture.get();
            System.out.println("Payment sent: $" + payment);
        } catch(InterruptedException | ExecutionException e) {
            System.out.println("Failed to get the payment result!");
        }
    }
}
