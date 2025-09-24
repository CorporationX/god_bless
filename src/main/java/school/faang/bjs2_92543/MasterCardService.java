package school.faang.bjs2_92543;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_COUNT = 5_000;
    private static final int ANALYTICS_COUNT = 17_000;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static Integer collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_COUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static Integer sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_COUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, executorService);
        Integer analyticsResult = analytics.join();
        System.out.printf("Отправлена аналитика: %s\n", analyticsResult);

        Future<Integer> collected = executorService.submit(MasterCardService::collectPayment);
        try {
            Integer result = collected.get();
            executorService.shutdownNow();
            System.out.printf("Выполнен платёж: %d\n", result);
        } catch (InterruptedException e) {
            log.info("Прервали в процессе ожидания");
            executorService.shutdownNow();
        } catch (ExecutionException e) {
            log.info("Ошибка в процессе обработки платежа");
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}