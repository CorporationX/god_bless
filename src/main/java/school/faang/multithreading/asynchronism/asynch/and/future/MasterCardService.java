package school.faang.multithreading.asynchronism.asynch.and.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TIME_TO_SLEEP_PAYMENT = 10_000;
    private static final int TIME_TO_SLEEP_ANALYTICS = 1_000;
    private static final int MAX_TIME_WORK = 10;
    private static final int THREADS_COUNT = 2;

    public int collectPayment() {
        log.info("Начинаем оплату...");
        try {
            Thread.sleep(TIME_TO_SLEEP_PAYMENT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Оплата успешно проведена");
        return TIME_TO_SLEEP_PAYMENT;
    }

    public int sendAnalytics() {
        log.info("Отправляем отчет...");
        try {
            Thread.sleep(TIME_TO_SLEEP_ANALYTICS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Отправили отчет по аналитике");
        return TIME_TO_SLEEP_ANALYTICS;
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        Future<Integer> collectPaymentFuture = executor.submit(this::collectPayment);

        CompletableFuture<Integer> analysticCompletableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        Integer resultAnalystic = analysticCompletableFuture.join();
        log.info("Аналитика отправлена: {}", resultAnalystic);

        executor.shutdown();

        try {
            executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Integer resultCollectPayment = collectPaymentFuture.get();
            log.info("Платеж отправлен: {}", resultCollectPayment);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
