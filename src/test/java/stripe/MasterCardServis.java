package stripe;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardServis {

    private String collectPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "result";
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1000;
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> paymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer analiticResult = analyticsFuture.join();
        System.out.println("Analytics data: " + analiticResult);
        try {
            String paymentResult = paymentFuture.get();
            System.out.println("Payment completed :" + paymentResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
