package school.faang.bjs282464;

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

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

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
            Future<Integer> paymentFuture =
                    executor.submit(() -> collectPayment());

            CompletableFuture<Integer> analyticsFuture =
                    CompletableFuture.supplyAsync(() -> sendAnalytics());

            Integer analyticsResult = analyticsFuture.get();
            log.info("Аналитика отправлена: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Операция была прервана", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Ошибка при выполнении операции", e.getCause());
        } finally {
            executor.shutdown();
        }
    }

    public void doAllWithCompletableFuture() {
        try {
            CompletableFuture<Integer> paymentFuture =
                    CompletableFuture.supplyAsync(() -> collectPayment());
            CompletableFuture<Integer> analyticsFuture =
                    CompletableFuture.supplyAsync(() -> sendAnalytics());

            Integer analyticsResult = analyticsFuture.get();
            log.info("Аналитика отправлена: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Операция была прервана", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Ошибка при выполнении операции", e.getCause());
        }
    }
}
