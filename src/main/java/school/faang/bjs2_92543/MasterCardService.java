package school.faang.bjs2_92543;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    private static Integer collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static Integer sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = analytics.join();
        System.out.printf("Отправлена аналитика: %s\n", analyticsResult);

        Future<Integer> collected = EXECUTOR_SERVICE.submit(MasterCardService::collectPayment);
        try {
            Integer result = collected.get();
            EXECUTOR_SERVICE.shutdownNow();
            System.out.printf("Выполнен платёж: %d\n", result);
        } catch (InterruptedException e) {
            log.info("Прервали в процессе ожидания");
            EXECUTOR_SERVICE.shutdownNow();
        } catch (ExecutionException e) {
            log.info("Ошибка в процессе обработки платежа");
            EXECUTOR_SERVICE.shutdownNow();
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}