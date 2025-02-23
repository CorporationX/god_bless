package school.faang;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 1;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static int collectPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return 1000;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return 3200;
    }

    public void doAll() {
        Future<Integer> futurePayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics);

        futureAnalytics.thenAccept(result -> System.out.println("Analytics has been sent: " + result));
        try {
            System.out.println("Payment has been completed: " + futurePayment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
