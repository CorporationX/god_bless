package school.faang.sprint_4.task_50011;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static final int ONE_SECOND = 1000;
    public static final int TEN_SECONDS = 10000;
    public static final int VALUE_PAYMENT = 10000;
    public static final int VALUE_ANALYTIC = 1000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS);
            return VALUE_PAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND);
            return VALUE_ANALYTIC;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        try {
            Integer paymentResult = paymentFuture.get();
            System.out.println("Птатеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
