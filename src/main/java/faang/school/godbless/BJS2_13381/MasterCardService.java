package faang.school.godbless.BJS2_13381;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    private static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> collectPaymentResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);
        while (!sendAnalyticsResult.isDone()) {
            System.out.println(sendAnalyticsResult.get());
        }
        while (!collectPaymentResult.isDone()) {
            System.out.println(collectPaymentResult.get());
        }
        executorService.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
