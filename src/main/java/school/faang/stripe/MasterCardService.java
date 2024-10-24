package school.faang.stripe;

import java.util.concurrent.*;

public class MasterCardService {


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

    public void doAll() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> result = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> comFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            System.out.println("Analytics result: " + comFuture.get());
            System.out.println("Payment result: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
