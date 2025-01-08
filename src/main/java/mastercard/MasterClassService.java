package mastercard;

import java.util.concurrent.*;

public class MasterClassService {
    static final long TIME = 10_000L;
    static final long SEC = 1_000L;
    static int collectPayment() {
        try {
            Thread.sleep(TIME);
            return (int) TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(SEC);
            return (int) SEC;
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
