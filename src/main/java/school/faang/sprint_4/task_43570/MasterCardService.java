package school.faang.sprint_4.task_43570;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int PAYMENT_VALUE = 10_000;
    private static final int ANALYTICS_VALUE = 1_000;
    private static final int POOL_SIZE = 2;

    private static int collectPayment() {
        simulateWork(PAYMENT_VALUE);
        return PAYMENT_VALUE;
    }

    private static int sendAnalytics() {
        simulateWork(ANALYTICS_VALUE);
        return ANALYTICS_VALUE;
    }

    private static void simulateWork(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван во время сна");
        }
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        System.out.println("Аналитика получена: " + analyticsFuture.join());
        System.out.println("Платеж выполнен: " + paymentFuture.get());

        executor.shutdown();
    }
}