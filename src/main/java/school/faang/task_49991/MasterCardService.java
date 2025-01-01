package school.faang.task_49991;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics)
                .thenAccept(result -> log.info("Аналитика отправлена: {}", result));

        try {
            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
