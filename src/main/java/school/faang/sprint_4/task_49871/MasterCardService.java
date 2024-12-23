package school.faang.sprint_4.task_49871;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int AWAIT_DELAY = 1;

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Future<Integer> collectedFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsCompletableFuture = CompletableFuture.supplyAsync(this::sendAnalytics,
                executorService);

        try {
            Integer collectedValue = collectedFuture.get();
            System.out.println("Payment completed " + collectedValue);
        } catch (InterruptedException e) {
            System.out.println("Payment interrupted");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Payment failed");
        }

        Integer analyticsData = analyticsCompletableFuture.join();
        System.out.println("Analytics sent " + analyticsData);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
