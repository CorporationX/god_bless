package school.faangSprint4.t01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
            Integer analyticsResult = analyticsFuture.join();
            System.out.println("Аналитика отправлена: " + analyticsResult);
            Integer paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}