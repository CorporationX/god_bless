package school.faang.asynchrony_and_future.BJS2_61988;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final Logger log = LoggerFactory.getLogger(MasterCardService.class);

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Обработка платежа была прервана: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Отправка аналитики была прервана: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        Future<Integer> payment = threadPool.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, threadPool);

        log.info("Платеж выполнен: {}", analytics.join());

        try {
            log.info("Аналитика отправлена: {}", payment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Произошла ошибка при выполнении задачи: {}", e.getMessage(), e);
            throw new RuntimeException("Ошибка при выполнении задачи", e);
        }

        threadPool.shutdown();
        try {
            if (threadPool.awaitTermination(1, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Прерывание при ожидании завершения пула потоков: {}", e.getMessage());
            threadPool.shutdownNow();
        }
    }
}
