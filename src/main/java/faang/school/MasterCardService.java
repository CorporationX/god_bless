package faang.school;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 3_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService s = new MasterCardService();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> payment = CompletableFuture.supplyAsync(s::collectPayment, executor);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(s::sendAnalytics, executor);

        System.out.println(payment.get());
        System.out.println(analytics.get());
        executor.shutdown();

        System.out.println("Doe");
    }
}
