package MultithreadingAsyncFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int TIMER = 10000;
    private static final int MIN_TIMER = 1000;

    public static int collectPayment() {
        try {
            Thread.sleep(TIMER);
        } catch (InterruptedException e) {
            log.debug(e.getMessage());
        }
        return 10000;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(MIN_TIMER);
        } catch (InterruptedException e) {
            log.debug(e.getMessage());
        }
        return 1000;
    }

    public void doAll() {
        ExecutorService ex = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Future<Integer> futureAnalyticsAmount = ex.submit(() -> sendAnalytics());
        CompletableFuture<Integer> futurePaymentAmount = CompletableFuture.supplyAsync(() -> collectPayment(), ex);

        try {
            futureAnalyticsAmount.get();
            if (futureAnalyticsAmount.isDone()) {
                System.out.println(futureAnalyticsAmount.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            log.debug(e.getMessage());
        }

        int futurePaymentResult = futurePaymentAmount.join();
        System.out.println(futurePaymentResult);

        ex.shutdown();
    }
}
