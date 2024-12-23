package school.faang.task_49910;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static long MILLISECOND_IN_SEC = 1000;
    public static long PAYMENT_SLEEP_TIME_SEC = 10;
    public static long ANALYTICS_SLEEP_TIME_SEC = 1;
    public static int PAYMENT_RESULT = 10000;
    public static int ANALYTICS_RESULT = 1000;

    public static int collectPayment() {
        sleepSec(PAYMENT_SLEEP_TIME_SEC);
        return PAYMENT_RESULT;
    }

    public static int sendAnalytics() {
        sleepSec(ANALYTICS_SLEEP_TIME_SEC);
        return ANALYTICS_RESULT;
    }

    @SneakyThrows
    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult = paymentFuture.get();
        System.out.println("Платеж выполнен: " + paymentResult);
        executor.shutdown();
    }

    private static void sleepSec(long sec) {
        try {
            Thread.sleep(sec * MILLISECOND_IN_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
