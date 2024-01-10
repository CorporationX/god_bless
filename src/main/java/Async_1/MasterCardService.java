package Async_1;

import java.util.concurrent.*;

public class MasterCardService {

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            System.out.println("Exception collectPayment");
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            System.out.println("Exception sendAnalytics");
            throw new RuntimeException();
        }

    }

    public static void doAll() {
        Future<Integer> future = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);

        try {
            int resultCompletableFuture = completableFuture.get();
            System.out.println(resultCompletableFuture);
        } catch (InterruptedException e) {
            System.out.println("completableFuture, InterruptedException");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("completableFuture, ExecutionException");
            throw new RuntimeException(e);
        }

        try {
            int resultFuture = future.get();
            System.out.println(resultFuture);
        } catch (InterruptedException e) {
            System.out.println("future, InterruptedException");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("future, ExecutionException");
            throw new RuntimeException(e);
        }
    }

    public static ExecutorService getExecutor() {
        return executor;
    }

}
