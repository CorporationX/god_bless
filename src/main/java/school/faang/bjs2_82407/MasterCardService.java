package school.faang.bjs2_82407;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = analyticsFuture.get();
            log.info("Analytics result: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Payment result: {}", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
    }
}