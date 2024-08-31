package faang.school.godbless.sprint4.asyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);
        System.out.println(completableFuture.join());
        while (!future.isDone()) {
        }
        System.out.println(future.get());
        executor.shutdown();
    }
}
