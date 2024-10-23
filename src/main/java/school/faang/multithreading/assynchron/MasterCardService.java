package school.faang.multithreading.assynchron;

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
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        System.out.println("Result of the analysis: " + future2.join());
        System.out.println("Result of the payment: " + future.get());

        executor.shutdown();
    }
}
