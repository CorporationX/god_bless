package faang.school.godbless.BJS224647;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics)
                .thenAccept(result -> System.out.println("Analytic finish, result: " + result)).join();

        executorService.shutdown();

        System.out.println("Payment finish, result: " + future.get());



    }
}
