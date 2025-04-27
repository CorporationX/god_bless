package school.faang.mastercard;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = analyticsFuture.get();
            log.info("Аналитика отправлена: {}", analyticsResult);

            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Операция была прервана", e);
        } catch (ExecutionException e) {
            log.error("Ошибка при выполнении операции", e);
        } finally {
            executor.shutdown();
        }
    }
}
