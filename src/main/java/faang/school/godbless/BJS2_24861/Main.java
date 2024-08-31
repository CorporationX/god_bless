package faang.school.godbless.BJS2_24861;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Main.doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        int completableFutureResult = completableFuture.get();
        System.out.println(completableFutureResult);
        int futureResult = future.get();
        System.out.println(futureResult);
        executor.shutdown();
    }
}
