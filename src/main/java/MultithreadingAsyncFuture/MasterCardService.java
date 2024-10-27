package MultithreadingAsyncFuture;

import java.util.concurrent.*;

public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 2;

    public static int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService ex = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Future<Integer> futureAnalyticsAmount = ex.submit(() -> sendAnalytics());
        try {
            futureAnalyticsAmount.get();
            if (futureAnalyticsAmount.isDone()) {
                System.out.println(futureAnalyticsAmount.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<Integer> futurePaymentAmount = CompletableFuture.supplyAsync(() -> collectPayment());
        int futurePaymentResult = futurePaymentAmount.join();
        System.out.println(futurePaymentResult);

        ex.shutdown();
    }
}
