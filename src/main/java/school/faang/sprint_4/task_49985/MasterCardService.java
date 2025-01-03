package school.faang.sprint_4.task_49985;

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
            System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
            return -1;
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
            return -1;
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executor.submit(this::collectPayment);

        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(this::sendAnalytics);

        int result = analyticsResult.get();
        System.out.println("Отправлена аналитика: " + result);

        result = paymentResult.get();
        System.out.println("Платёж обработан: " + result);
    }
}
