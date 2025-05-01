package bjs2_74530;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void doAll() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> payments = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(() -> sendAnalytics());

        Integer analyticsResult = analytics.get();
        log.info("The analysis has been completed: {}", analyticsResult);

        Integer paymentsResult = payments.get();
        log.info("The payment has been sent: {}", paymentsResult);
        executor.shutdown();
    }
    public static void main(String[] args) throws Exception {
        doAll();
    }
}
