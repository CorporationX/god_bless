package school.faang.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        int resultAnalytic = analytic.join();
        int resultPayment;
        try {
            resultPayment = payment.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            resultPayment = 0;
        }

        System.out.println("Аналитика отправлена: " + resultPayment);
        System.out.println("Платеж выполнен: " + resultAnalytic);

    }
}
