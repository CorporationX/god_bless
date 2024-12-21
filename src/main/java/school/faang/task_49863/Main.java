package school.faang.task_49863;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> taskPayment = CompletableFuture.supplyAsync(() -> {
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

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(taskAnalytics, taskPayment);
        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error : " + exception.getMessage());
            } else {
                try {
                    System.out.println("Payment task : " + taskPayment.get());
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