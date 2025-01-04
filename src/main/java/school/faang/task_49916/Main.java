package school.faang.task_49916;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return masterCardService.collectPayment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        CompletableFuture<Integer> taskAnalytics = CompletableFuture.supplyAsync(() -> {
            try {
                return masterCardService.sendAnalytics();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(taskAnalytics, analyticsFuture);
        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error : " + exception.getMessage());
            } else {
                try {
                    System.out.println("Payment task : " + analyticsFuture.get());
                    System.out.println("Analytics task : " + taskAnalytics.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}
