package school.faang.bjs250199;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    public static final int NUMBER_OPERATION_ANALYTICS = 1_000;
    public static final int NUMBER_OPERATION_PAYMENTS = 10_000;

    public static int collectPayment() {
        try {
            Thread.sleep(NUMBER_OPERATION_PAYMENTS);
            return NUMBER_OPERATION_PAYMENTS;
        } catch (InterruptedException ex) {
            log.error("The task has been aborted!{}", String.valueOf(ex));
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(NUMBER_OPERATION_ANALYTICS);
            return NUMBER_OPERATION_ANALYTICS;
        } catch (InterruptedException ex) {
            log.error("The task has been aborted!{}", String.valueOf(ex));
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        Integer paymentResult;
        try {
            paymentResult = paymentFuture.get();
        } catch (InterruptedException | ExecutionException ex) {
            log.error("The task has been aborted!{}", String.valueOf(ex));
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
        System.out.println("Платеж выполнен: " + paymentResult);
        executor.shutdown();
    }
}
