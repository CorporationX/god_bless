package school.faang.sprint4.task_49875;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int SEND_ANALYTICS_TIME = 1000;
    private static final int COLLECT_PAYMENT_TIME = 10000;
    private static final int PAYMENT_VALUE = 5000;
    private static final int ANALYTICS_VALUE = 1000;

    public int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_TIME);
            return PAYMENT_VALUE;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_TIME);
            return ANALYTICS_VALUE;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Analytics were send: " + analyticsResult);

        try {
            Integer paymentResult = paymentFuture.get();
            System.out.println("Payment was processed: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
