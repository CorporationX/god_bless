package school.faang.BJS238043;

import java.util.concurrent.CompletableFuture;
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
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult = null;
        try {
            paymentResult = paymentFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Платеж выполнен: " + paymentResult);
    }
}
