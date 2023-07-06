package faang.school.godbless.asynchronyAndFuture;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class MasterCardService {

    MasterCardService masterCardService = new MasterCardService();

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(() -> collectPayment());
        int realResult = result.get();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());
        completableFuture.join();

        System.out.println(realResult);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
