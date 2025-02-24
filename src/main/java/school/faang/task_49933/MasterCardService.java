package school.faang.task_49933;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Exception " + e);
        }

        System.out.println("Оплата произведена!!!");
        return 5000;
    }

    public int sendAnalytics() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception " + e);
        }
        System.out.println("Аналитика отправленна!!!");
        return 1000;
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> payment = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(() -> {
            try {
                return sendAnalytics();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        futureAnalytics.thenAccept(n -> System.out.println(n));

        try {
            System.out.println(payment.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }
}
