package school.faang.task_49895;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public static void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> analytics = service.submit(() -> sendAnalytics());

        CompletableFuture<Integer> payment = CompletableFuture.supplyAsync(() -> collectPayment());

        try {
            System.out.println("Аналитика отправлена: " + analytics.get());
            System.out.println("Платеж выполнен: " + payment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.warn("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            return;
        }

        service.shutdown();
    }
}
