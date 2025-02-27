package BJS261946;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentfuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(()
                -> sendAnalytics(), executor);
        try {
            Integer paymentResult = analyticsFuture.join();
            Integer analyticsResult = paymentfuture.get();
            executor.shutdown();
            System.out.println("Analytic  result: " + analyticsResult);
            System.out.println("Payment result: " + paymentResult);
        } catch (ExecutionException | InterruptedException e) {
            log.error("Error in method do All", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}
