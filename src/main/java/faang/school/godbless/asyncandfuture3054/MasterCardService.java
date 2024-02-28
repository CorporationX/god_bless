package faang.school.godbless.asyncandfuture3054;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        doAll();
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
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectResult = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);

        System.out.println("Waiting for results...");
        System.out.println("analyticsResult = " + analyticsResult.get(15L, TimeUnit.SECONDS));
        System.out.println("collectResult = " + collectResult.get(15L, TimeUnit.SECONDS));

        executor.shutdown();
    }
}
