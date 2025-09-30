package school.faang.bjs2_92766;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    private static final int PAYING_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;

    public static int collectPayment() {
        System.out.println("Платеж в обработке...");
        try {
            Thread.sleep(PAYING_TIME);
            return 1;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    public static int sendAnalytics() {
        System.out.println("Отправка аналитики");
        try {
            Thread.sleep(ANALYTICS_TIME);
            return 2;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    public static void doAll() {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult;
        try {
            paymentResult = paymentFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Платеж выполнен: " +  paymentResult);
        executor.shutdown();
    }

}
