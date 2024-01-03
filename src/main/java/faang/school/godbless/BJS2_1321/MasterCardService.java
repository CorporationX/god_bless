package faang.school.godbless.BJS2_1321;

import java.util.concurrent.*;

public class MasterCardService {

    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        executor.shutdown();

        try {
            System.out.println("Collect payment result: " + collectPaymentResult.get(15_000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Send analytics result: " + sendAnalyticsResult.join());
    }

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
}