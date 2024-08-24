package faang.school.multithreadingparallelismthread.asynchronyandthefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MasterCardService {

    private static final int SLEEP_COLLECT = 10_000;
    private static final int SLEEP_ANALYTICS = 5_000;

    private static int collectPayment() {
        try {
            Thread.sleep(Long.parseLong(String.valueOf(SLEEP_COLLECT)));
            return SLEEP_COLLECT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(Long.parseLong(String.valueOf(SLEEP_ANALYTICS)));
            return SLEEP_ANALYTICS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println(sendAnalyticsResult.get() + " " + Thread.currentThread().getName());
        System.out.println(collectPaymentResult.get() + " " + Thread.currentThread().getName());

        executor.shutdown();

        try {
            if (!executor.awaitTermination(3, SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
