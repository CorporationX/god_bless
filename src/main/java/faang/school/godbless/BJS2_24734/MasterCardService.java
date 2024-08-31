package faang.school.godbless.BJS2_24734;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            Integer analyticsResult = analyticsFuture.get();
            System.out.println("Analytics result: " + analyticsResult);

            Integer paymentResult = paymentFuture.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
