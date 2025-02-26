package school.faang.BJS2_61860;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int ANALYTICS_RESULT = 17_000;
    private static final int PAYMENT_RESULT = 5_000;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<>(this::sendAnalytics);
        executorService.submit(futureTask);

        int analyticsResult;
        try {
            analyticsResult = futureTask.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Analytics send: %d", analyticsResult));

        try {
            executorService.shutdown();
        } catch (SecurityException e) {
            System.err.println("Failed to shutdown executor due to security restrictions: " + e.getMessage());
            return;
        }

        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                System.err.println("Executor did not terminate in 20 seconds, forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Await termination interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }


        CompletableFuture<Integer> paymentResult = CompletableFuture.supplyAsync(this::collectPayment);
        paymentResult
                .thenAccept((result) -> System.out.println(String.format("Payment completed: %d", result)))
                .exceptionally(throwable -> {
                    System.err.println("Error: " + throwable.getCause().getMessage());
                    return null;
                })
                .join();
    }

    public static void main(String[] args) {

        System.out.println("Start process!");
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}

