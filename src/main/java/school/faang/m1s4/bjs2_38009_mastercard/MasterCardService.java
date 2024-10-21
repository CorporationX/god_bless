package school.faang.m1s4.bjs2_38009_mastercard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return 10_000;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return 1_000;
    }

    public void doAll() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> resultPayment = service.submit(() -> collectPayment());
        CompletableFuture<Integer> resultAnalytics = CompletableFuture.supplyAsync(() -> sendAnalytics());

        System.out.printf("Analytics sent: %d%n", resultAnalytics.join());
        try {
            System.out.printf("Payment proceed: %d%n", resultPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(15, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
