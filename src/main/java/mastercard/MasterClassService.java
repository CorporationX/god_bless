package mastercard;

import java.util.concurrent.*;

public class MasterClassService {
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
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executor.submit(() -> MasterClassService.collectPayment());
        CompletableFuture<Integer> analiticsFuture = CompletableFuture.supplyAsync(()
                -> MasterClassService.sendAnalytics());

        try {
            Integer paymentResult = paymentFuture.get();
            Integer analyticsResult = analiticsFuture.get();

            System.out.println("Аналитика отправлена: " + analyticsResult);
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
