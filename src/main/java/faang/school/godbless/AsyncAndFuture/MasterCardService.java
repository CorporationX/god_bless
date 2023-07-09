package faang.school.godbless.AsyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(3000);
            return 3000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        completableFuture.thenAccept(num -> System.out.println("Analytics: " + num));
        System.out.println("Collected payment: " + future.get());

        executor.shutdown();
    }
}
