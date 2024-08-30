package async.one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> futureSendAnalystics = CompletableFuture.supplyAsync(() -> sendAnalystics());

        futureSendAnalystics.thenAccept(result -> {
            System.out.println("sendAnalystics: " + result);
        });

        try {
            int collectPaymentResult = futureCollectPayment.get();
            System.out.println("collectPayment result: " + collectPaymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
