package school.faang.asyncfuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted while collecting payment", e);
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
        try {
            Future<Integer> paymentFuture = CompletableFuture.supplyAsync(() -> {
                return MasterCardService.collectPayment();
            }, executor);

            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> {
                return MasterCardService.sendAnalytics();
            }, executor);
            Integer analyticsResult = analyticsFuture.join();
            logger.info("Analytics sent: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            logger.info("Payment sent: {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
