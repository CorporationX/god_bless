package school.faang.asyncfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Collect Payment - thread interrupted");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Send Analytics - thread interrupted");
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> futurePayment = executor.submit(this::collectPayment);

        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        futureAnalytics.thenAccept(result -> System.out.println("Analytics: " + result));

        try {
            System.out.println("Payment: " + futurePayment.get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Do All task - Payment thread interrupted");
        }

        executor.shutdown();
    }
}
