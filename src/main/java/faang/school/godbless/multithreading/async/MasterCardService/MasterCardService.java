package faang.school.godbless.multithreading.async.MasterCardService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorCollectPayment = Executors.newFixedThreadPool(2);
        ExecutorService executorSendAnalytics = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentFuture = executorCollectPayment.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorSendAnalytics);

        System.out.println("Time to send analytics - " + sendAnalyticsFuture.join() + " ms");
        System.out.println("Time to collect payment - " + collectPaymentFuture.get() + " ms");
        executorCollectPayment.shutdown();
        executorSendAnalytics.shutdown();
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
