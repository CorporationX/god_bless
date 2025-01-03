package school.faang.bjs249921;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted. Error: " + e);
            e.printStackTrace();
        }
        return 10_000;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted. Error: " + e);
            e.printStackTrace();
        }
        return 1_000;
    }

    public static void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);
        Future<Integer> future2 = executorService.submit(MasterCardService::collectPayment);

        executorService.shutdown();
        try {
            int result1 = future1.get();
            System.out.println("Analytics sent: " + result1);
            int result2 = future2.get();
            System.out.println("Payment execute: " + result2);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted. Error: " + e);
        } catch (ExecutionException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
