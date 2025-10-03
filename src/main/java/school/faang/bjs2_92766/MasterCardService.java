package school.faang.bjs2_92766;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    private static final int PAYING_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;
    private static final int MAGIC_NUMBER_ONE = 1;
    private static final int MAGIC_NUMBER_TWO = 2;

    public static int collectPayment() {
        System.out.println("Платеж в обработке...");
        try {
            Thread.sleep(PAYING_TIME);
            return MAGIC_NUMBER_ONE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    public static int sendAnalytics() {
        System.out.println("Отправка аналитики");
        try {
            Thread.sleep(ANALYTICS_TIME);
            return MAGIC_NUMBER_TWO;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    public static void doAll() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult;
        try {
            paymentResult = paymentFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Платеж выполнен: " + paymentResult);
        executor.shutdown();
    }

}