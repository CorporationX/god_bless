package school.faang.asin_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    private static final int THREAD_POOL = 2;
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = analyticFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);
        Integer paymentResult;
        try {
            paymentResult = paymentFuture.get(30, TimeUnit.SECONDS);
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException("Произошло прерывание операции");
        } catch (ExecutionException e) {
            throw new RuntimeException("Ошибка выполнения операции");
        } catch (TimeoutException e) {
            throw new RuntimeException("Тайм аут");
        } finally {
            executor.shutdownNow();
        }
        System.out.println("Платеж выполнен: " + paymentResult);
    }
}