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
    private static final int PAYMENT_DELAY = 10000;
    private static final int PAYMENT_VALUE = 10000;
    private static final int ANALYTICS_DELAY = 10000;
    private static final int ANALYTICS_VALUE = 10000;

    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY);
            return PAYMENT_VALUE;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY);
            return ANALYTICS_VALUE;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return 0;
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
