package faang.school.godbless.mt.asyncfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            executor.shutdown();

            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

            Integer analyticsResult = analyticsFuture.join();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            Integer paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
