package school.faang.Multithreading.sprint_4.AsynchronyFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> futureTimePay = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> timeAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Аналитика отправлена: " + timeAnalytics.join());

        try {
            System.out.println("Платеж выполнен: " + futureTimePay.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}