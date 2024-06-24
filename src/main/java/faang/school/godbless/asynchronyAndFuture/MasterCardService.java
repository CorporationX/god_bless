package faang.school.godbless.asynchronyAndFuture;

import java.util.concurrent.*;

public class MasterCardService {
    private int NUM_THREAD = 5;

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);
        Future future = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        System.out.println("Future: " + future.get());
        System.out.println("CompletableFuture: " + future.get());
        executorService.shutdown();
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}