package faang.school.godbless.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPayment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        sendAnalytics.join();

        try {
            System.out.println("collectPayment: " + collectPayment.get());
            System.out.println("sendAnalytics: " + sendAnalytics.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        executor.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
