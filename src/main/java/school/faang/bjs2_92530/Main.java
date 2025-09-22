package school.faang.bjs2_92530;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        doAll();
    }

    static void doAll() {
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics).thenAccept(System.out::println);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> result1 = executor.submit(MasterCardService::collectPayment);

        try {
            System.out.println(result1.get());
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
