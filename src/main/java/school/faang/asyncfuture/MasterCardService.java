package school.faang.asyncfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(3_000);
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

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> completableFuture = service.submit(() -> collectPayment());
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> sendAnalytics());
        int resultOne =completableFuture.get();
        int resultTwo =completableFuture2.join();
        service.shutdown();
        System.out.println("Результат один " + resultOne + " результат два " + resultTwo);
    }
}
