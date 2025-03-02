package BJS261946;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int FIVE_SECONDS_IN_MS = 5_000;
    private static final int SEVENTEEN_SECONDS_IN_MS = 17_000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return FIVE_SECONDS_IN_MS;
        } catch (InterruptedException e) {
            log.error("We have interrupted while waiting for payment to be collected", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return SEVENTEEN_SECONDS_IN_MS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentfuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        try {
            Integer analyticsResult = paymentfuture.get();
            Integer paymentResult = analyticsFuture.join();
            System.out.println("Analytic  result: " + analyticsResult);
            System.out.println("Payment result: " + paymentResult);
        } catch (ExecutionException | InterruptedException e) {
            log.error("Error in method do All", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }

    }
}
