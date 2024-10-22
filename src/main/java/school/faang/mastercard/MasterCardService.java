package school.faang.mastercard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TIME_TO_ANALYTICS = 1_000;
    private static final int TIME_TO_PAYMENT = 10_000;
    private static final int MAX_TIME_WORK = 10;
    public int collectPayment() {
        try {
            Thread.sleep(TIME_TO_PAYMENT);
            return TIME_TO_PAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(TIME_TO_ANALYTICS);
            return TIME_TO_ANALYTICS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        executor.shutdown();
        try {
            executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Integer paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
