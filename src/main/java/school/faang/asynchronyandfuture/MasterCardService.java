package school.faang.asynchronyandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

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
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(() -> MasterCardService.collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(
                () -> MasterCardService.sendAnalytics());
        executor.shutdown();

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        Integer paymentResult = paymentFuture.get();
        System.out.println("Платеж выполнен: " + paymentResult);
    }
}
