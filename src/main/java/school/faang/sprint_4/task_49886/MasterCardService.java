package school.faang.sprint_4.task_49886;

import java.util.concurrent.*;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка collectPayment");
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка sendAnalytics");
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executorService);
        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);
        try {
            int analyticsResult = analyticsFuture.join();
            System.out.println("Analytics result: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}