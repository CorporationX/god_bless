package faang.school.godbless.AcyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            logger.error("Interrupted while collecting payment", e);
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            logger.error("Interrupted while sending analytics", e);
            throw new RuntimeException();
        }
    }
    public static void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = sendAnalyticsFuture.get();
            System.out.println("Analytics result: " + analyticsResult);

            int paymentResult = collectPaymentFuture.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Exception occurred during execution", e);
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        doAll();
    }
}
