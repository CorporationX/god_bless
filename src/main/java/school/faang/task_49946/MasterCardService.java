package school.faang.task_49946;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> futurePayment = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        try {
            Integer futureResult = futurePayment.get();
            System.out.println("Платеж выполнен: " + futureResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка результата", e);
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка отправки платежа", e);
            throw new RuntimeException("Ошибка при обработке платежа", e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Ошибка отправки аналитики", e);
            throw new RuntimeException("Ошибка при отправке аналитики", e);
        }
    }

}
