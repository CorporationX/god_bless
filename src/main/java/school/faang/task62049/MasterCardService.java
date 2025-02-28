package school.faang.task62049;

import lombok.SneakyThrows;

import java.util.concurrent.*;

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

    @SneakyThrows
    public void doAll() {
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = analytics.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
            Integer paymentResult = payment.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        }
    }
}