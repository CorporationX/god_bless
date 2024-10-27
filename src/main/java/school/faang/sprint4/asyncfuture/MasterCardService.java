package school.faang.sprint4.asyncfuture;

import java.util.concurrent.*;

public class MasterCardService {

    public void doAll() {
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            if (analyticsResult.get() != 0) {
                System.out.println("Аналитика отправлена: 1000");

                Future<Integer> paymentResult = executor.submit(MasterCardService::collectPayment);
                paymentResult.get(30000, TimeUnit.MILLISECONDS);

                System.out.println("Платеж выполнен: 10000");
            }
        } catch (Exception e) {
            System.out.println("Платеж не прошел, попробуйте еще раз");
        } finally {
            executor.shutdown();
        }
    }

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
}
