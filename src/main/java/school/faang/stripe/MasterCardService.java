package school.faang.stripe;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int DELAY_10_SEC = 10000;
    private static final int DELAY_1_SEC = 1000;

    public int collectPayment() {
        System.out.println("collecting payments...");

        try {
            Thread.sleep(DELAY_10_SEC);
            return DELAY_10_SEC;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        System.out.println("Send analytics ... ");
        try {
            Thread.sleep(DELAY_1_SEC);
            return DELAY_1_SEC;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        CompletableFuture<Integer> analyticsFuture = callSendAnalytics();
        analyticsFuture.thenAccept(result -> {
            System.out.println("Analytics result: " + result);
            System.out.println("Analytics sent successfully!");
        }).join();
        callCollectPayment();
        System.out.println("doAll successfully done!");

    }

    private Future<Integer> callCollectPayment() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> collectPayment();

        Future<Integer> future = executor.submit(task);
        try {
            Integer result = future.get();
            System.out.println("collecting result:" + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
        return future;
    }

    private CompletableFuture<Integer> callSendAnalytics() {

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() ->
                sendAnalytics()
        );
        return analyticsFuture;
    }
}
