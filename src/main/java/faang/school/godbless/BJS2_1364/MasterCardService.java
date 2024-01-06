package faang.school.godbless.BJS2_1364;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> resultFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> resultCompletableFuture = CompletableFuture.supplyAsync(() -> sendAnalystics());

        System.out.println(resultCompletableFuture.join());
        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted exception when getting collectPayment method");
        } catch (ExecutionException e) {
            throw new RuntimeException("Execution exception when getting collectPayment");
        }

        executor.shutdown();
    }
}
