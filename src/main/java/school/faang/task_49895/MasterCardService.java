package school.faang.task_49895;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int DELAY_1 = 10000;
    private static final int DELAY_2 = 1000;

    static int collectPayment() {
        try {
            Thread.sleep(DELAY_1);
            return DELAY_1;
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }
    }


    static int sendAnalytics() {
        try {
            Thread.sleep(DELAY_2);
            return DELAY_2;
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }
    }

    public static void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> analytics = service.submit(() -> sendAnalytics());

        CompletableFuture<Integer> payment = CompletableFuture.supplyAsync(() -> collectPayment());

        try {
            System.out.println("Аналитика отправлена: " + analytics.get());
            System.out.println("Платеж выполнен: " + payment.get());
        } catch (ExecutionException e) {
            log.error("ExecutionException occurred", e);
        } catch (InterruptedException e) {
            log.warn("Main thread was interrupted", e);
            Thread.currentThread().interrupt();
        }

        service.shutdown();
    }
}
