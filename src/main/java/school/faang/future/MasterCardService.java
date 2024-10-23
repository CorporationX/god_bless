package school.faang.future;

import java.util.concurrent.*;

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
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> paymentFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                return collectPayment();
            }
        });

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());

        try {
            int analyticsResult = analyticsFuture.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
