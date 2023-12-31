package faang.school.godbless.multithreading_async.asynchrony_and_the_future;

import java.util.concurrent.*;

import static faang.school.godbless.multithreading_async.asynchrony_and_the_future.MasterCardService.collectPayment;
import static faang.school.godbless.multithreading_async.asynchrony_and_the_future.MasterCardService.sendAnalytics;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }


    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());

        System.out.println("Start!");
        System.out.println(completableFuture.get());
        System.out.println(future.get());


    }

}
