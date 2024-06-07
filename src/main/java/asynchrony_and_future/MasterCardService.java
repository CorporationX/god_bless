package asynchrony_and_future;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    @SneakyThrows
    public static int collectPayment() {
        Thread.sleep(10_000);
        return 10_000;
    }

    @SneakyThrows
    public static int sendAnalytics() {
        Thread.sleep(1_000);
        return 1000;
    }

    @SneakyThrows
    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());
        executor.shutdown();

        System.out.println(completableFuture.get());
        System.out.println(future.get());
    }

    public static void main(String[] args) {
        doAll();
    }
}
