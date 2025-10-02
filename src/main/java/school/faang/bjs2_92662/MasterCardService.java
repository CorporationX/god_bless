package school.faang.bjs2_92662;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsCompletableFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            System.out.println("Аналитика отправлена: " +
                    analyticsCompletableFuture.get(20, TimeUnit.SECONDS));
            System.out.println("Платеж выполнен: " +
                    paymentFuture.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ожидание прервано.");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            System.err.println("Ошибка выполнения задачи: " + cause.getMessage());
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }


    }

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
}
