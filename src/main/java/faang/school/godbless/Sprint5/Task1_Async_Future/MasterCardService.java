package faang.school.godbless.Sprint5.Task1_Async_Future;

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
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static void doAll() {

        MasterCardService mcService = new MasterCardService();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> collectPaymentFuture = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Waiting for sendAnalytics...");
        int sendAnalyticsResult = sendAnalyticsFuture.join();
        System.out.println("sendAnalytics result: " + sendAnalyticsResult);

        try {
            int collectPaymentResult = collectPaymentFuture.get();
            System.out.println("collectPayment result: " + collectPaymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
        doAll();
    }
}