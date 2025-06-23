package school.faang.cardservice;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CardServiceTesting {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        MasterCardService service = new MasterCardService();

        Future<Integer> paymentResult = executor.submit(() -> service.collectPayment());
        CompletableFuture<Integer> analyticsResult =
                CompletableFuture.supplyAsync(() -> service.sendAnalytics(), executor);


        try {
            Integer finalAnalyticsResult = analyticsResult.get();
            log.info(finalAnalyticsResult.toString());

            Integer finalPaymentResult = paymentResult.get();
            log.info(finalPaymentResult.toString());
        } catch (InterruptedException e) {
            log.error("Поток был прерван.");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Ошибка выполнения задачи.");
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
