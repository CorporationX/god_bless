package school.faang.asynchronyandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
