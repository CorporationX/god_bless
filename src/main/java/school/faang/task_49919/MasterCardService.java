package school.faang.task_49919;

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

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            Integer analyticsResult = analyticsFuture.get(5, TimeUnit.SECONDS);
            System.out.println("Analytics sent: " + analyticsResult);

            Integer paymentResult = paymentFuture.get(15, TimeUnit.SECONDS);
            System.out.println("Payment completed: " + paymentResult);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}