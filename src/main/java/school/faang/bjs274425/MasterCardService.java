package school.faang.bjs274425;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10000);
            return 5000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 17000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);
            int paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Операция была прервана: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("Ошибка выполнения задачи: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }
}
