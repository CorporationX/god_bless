package faang.school.godbless.asynchFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class MasterCardService {
    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        sendAnalyticsFuture.thenAccept(result -> {
            System.out.println("Send result of analysis: " + result);
        });

        try {
            int collectPaymentResult = collectPaymentFuture.get();
            System.out.println("Collect payment results: " + collectPaymentResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
