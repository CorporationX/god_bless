package school.faang.BJS238043;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int PAYMENT_TIME = 10_000;
    private static final int ANALYTIC_TIME = 1_000;

    private static final int WAITING_TIME_IN_MINUTE = 1;

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_TIME);
            return PAYMENT_TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTIC_TIME);
            return ANALYTIC_TIME;
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
        try {
            System.out.println("Платеж выполнен: " + paymentFuture.get());
            service.shutdown();
            if (!service.awaitTermination(WAITING_TIME_IN_MINUTE, TimeUnit.MINUTES)) {
                System.out.println("Повторите платеж еще раз!");
                service.shutdownNow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
