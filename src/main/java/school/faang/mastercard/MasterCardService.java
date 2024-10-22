package school.faang.mastercard;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.supplyAsync(() -> (sendAnalytics()), executorService)
                .thenAccept((resalt) -> System.out.println("Аналитика отправлена: " + resalt)).join();

        Future<Integer> pay = executorService.submit(() -> (collectPayment()));
        while (pay.isDone()) {
        }
        System.out.println("Платеж выполнен: " + pay.get());
        executorService.shutdown();
    }
}

