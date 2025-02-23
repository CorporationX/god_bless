package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
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
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analysis = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
            Integer analyticsResult = analysis.join();
            System.out.println("Аналитика отправлена: " + analyticsResult);
            Integer paymentResult = payment.get();
            System.out.println("Платеж выполнен: " + paymentResult);
            executor.shutdown();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.info("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
