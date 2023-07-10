package faang.school.godbless.multithreading.async_future.async_and_future;

import java.util.concurrent.*;

public class MasterCardService {

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
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("log 1");
        CompletableFuture
                .supplyAsync(() -> sendAnalytics())
                .thenAccept((result) -> System.out.println("sendAnalytics " + result));
        System.out.println("log 2");
        Future<Integer> futureResult = executor.submit(() -> collectPayment());
        int payments;
        try {
            payments = futureResult.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("collectPayment " + payments);
        executor.shutdown();

    }


}
