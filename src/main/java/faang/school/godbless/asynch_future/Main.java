package faang.school.godbless.asynch_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture
                = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        while (!completableFuture.isDone()) {
            System.out.println("Поток " + completableFuture + " в работе!");
        }
        while (!future.isDone()) {
            System.out.println("Поток " + future + " в работе!");
        }

        System.out.println("completableFuture = " + completableFuture.get());
        System.out.println("future = " + future.get());

        if (completableFuture.isDone()) {
            System.out.println("Поток " + completableFuture + " завершён.");
        }
        if (future.isDone()) {
            System.out.println("Поток " + future + " завершён.");
        }
        executor.shutdown();
    }
}
