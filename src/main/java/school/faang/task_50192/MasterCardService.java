package school.faang.task_50192;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analytics.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            int paymentResult = payment.get();
            System.out.println("Платеж выполнен: " + paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}