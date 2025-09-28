package school.faang.m1.future.mastercard;

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

    private final ExecutorService paymentExecutor = Executors.newSingleThreadExecutor();

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

    void doAll() {
        Future<Integer> payment = paymentExecutor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        try {
            analytics.join();
            System.out.println("Аналитика отправлена: " + analytics);

            payment.get(10000, TimeUnit.MILLISECONDS);
            System.out.println("Платеж выполнен: " + payment);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            paymentExecutor.shutdown();
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
