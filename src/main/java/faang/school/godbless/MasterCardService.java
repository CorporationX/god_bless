package faang.school.godbless;

import java.util.concurrent.*;

public class MasterCardService {

    static int collectPayment(){
        return 1_000;
    }

    static int sendAnalytics(){
        return 10_000;
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture <Integer> analyticsResult = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);
        String result = Thread.currentThread().getName() + " analytics - " + analyticsResult.get();
        Future <Integer> paymentResult = executor.submit(() -> collectPayment());
        System.out.println(result);
        result = Thread.currentThread().getName() + " payment - " + paymentResult.get();
        System.out.println(result);
        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }
}
