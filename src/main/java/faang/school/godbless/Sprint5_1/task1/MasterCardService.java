package faang.school.godbless.Sprint5_1.task1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 3_000;
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

    static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        sendAnalyticsResult.thenAccept(result -> System.out.println("SendAnalytics: " + result)).join();

        try {
            System.out.println("CollectPayment: " + collectPaymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        doAll();
    }
}
