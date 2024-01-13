package faang.school.godbless.multithreading.async.MasterCardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Time to send analytics - " + sendAnalyticsFuture.join() + " ms");
        System.out.println("Time to collect payment - " + collectPaymentFuture.get() + " ms");
        executor.shutdown();

    }

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            logger.error("An error has occurred ", e);
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            logger.error("An error has occurred ", e);
            throw new RuntimeException();
        }
    }
}
