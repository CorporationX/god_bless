package dima.evseenko.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Ошибка оплаты!", e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Ошибка отправки аналитики!", e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture.supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(result -> System.out.printf("Аналитика отправлена: %s%n", result));

        Future<Integer> paymentResult = executorService.submit(this::collectPayment);
        System.out.printf("Платеж выполнен: %s%n", paymentResult.get());

        executorService.shutdown();
    }
}
