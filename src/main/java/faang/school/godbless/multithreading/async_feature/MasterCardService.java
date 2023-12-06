package faang.school.godbless.multithreading.async_feature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPayment = executor.submit(this::collectPayment);
        executor.shutdown();
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        analytics.thenAccept(System.out::println);
        System.out.println(collectPayment.get());
    }

    private int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
