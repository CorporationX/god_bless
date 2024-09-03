package faang.school.godbless.dolbahlop.multithreading.synchronism;

import ch.qos.logback.core.model.INamedModel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    static int collectPaymaent() {
        System.out.println("Starting collector");
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            System.out.println("Collector failed");
        }
        return 0;
    }

    static int sendAnalytics() {
        System.out.println("Start sanding analytics");
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.out.println("Sanding analytics have failed");
        }
        return 0;
    }

    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> payments = executorService.submit(MasterCardService::collectPaymaent);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        int paymentsResult = payments.get(300, TimeUnit.SECONDS);
        System.out.println("Payment result: " + paymentsResult);

        int analyticsResult = analytics.get(300, TimeUnit.SECONDS);
        System.out.println("Analytics result: " + analyticsResult);

        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        doAll();
    }
}
