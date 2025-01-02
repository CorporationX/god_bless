package school.faang.sprint4.bjs249976;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка в транзакции оплаты: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Ошибка в отправки аналитики: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> pay = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

            Integer analyticResult = analytic.join();
            System.out.println("Аналитика отправлена: " + analyticResult);

            Integer payResult = pay.get();
            System.out.println("Платеж выполнен: " + payResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка при выполнении потока для обработки транзакций: {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}