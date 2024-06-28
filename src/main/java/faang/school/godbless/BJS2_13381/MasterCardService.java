package faang.school.godbless.BJS2_13381;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        doAll();
    }

    private static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> collectPaymentResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        System.out.println(sendAnalyticsResult.join());
        System.out.println(collectPaymentResult.get(20, TimeUnit.SECONDS));

        executorService.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + " поток был прерван");
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + " поток был прерван");
            throw new RuntimeException();
        }
    }
}
