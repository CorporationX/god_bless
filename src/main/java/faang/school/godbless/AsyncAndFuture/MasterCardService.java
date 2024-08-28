package faang.school.godbless.AsyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doALl() {
        CompletableFuture<Void> futureResult1 = CompletableFuture.supplyAsync(() -> collectPayment())
                .thenAccept(result -> System.out.println("Результат " + result));
        CompletableFuture<Void> futureResult2 = CompletableFuture.supplyAsync(() -> sendAnalytics())
                .thenAccept(result -> System.out.println("Результат " + result));

        futureResult2.join();
        futureResult1.join();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> masterCardService.doALl());
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}