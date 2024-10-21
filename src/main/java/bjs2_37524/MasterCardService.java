package bjs2_37524;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> futureResultPaymentCollect = EXECUTOR_SERVICE.
                submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureResultSendAnalytics = CompletableFuture.
                supplyAsync(MasterCardService::sendAnalytics);

        int sentAnalytics = futureResultSendAnalytics.join();
        int collectedAmount = futureResultPaymentCollect.get();

        System.out.printf("Analytics sent: %d\nPayment collected: %d", sentAnalytics, collectedAmount);

        shutdownExecutorService();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void shutdownExecutorService() throws InterruptedException {
        EXECUTOR_SERVICE.shutdown();

        if (!EXECUTOR_SERVICE.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Time limit reached. Forcing shutdown");
            EXECUTOR_SERVICE.shutdownNow();
        }
    }
}
