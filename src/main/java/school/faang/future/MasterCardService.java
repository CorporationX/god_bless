package school.faang.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        FutureTask<Integer> paymentFuture = new FutureTask<>(MasterCardService::collectPayment);
        new Thread(paymentFuture).start();
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync((MasterCardService::sendAnalytics));
        try {
            System.out.println("Аналитика отправлена: " + analyticsFuture.get());
            System.out.println("Платеж выполнен: " + paymentFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
