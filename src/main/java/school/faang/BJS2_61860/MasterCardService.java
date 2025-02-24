package school.faang.BJS2_61860;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sentAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<>(this::sentAnalytics);
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
        System.out.println("Analytics send: %d".formatted(analyticsResult));

        try {
            executorService.shutdown();
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture<Integer> paymentResult = CompletableFuture.supplyAsync(this::collectPayment);
        paymentResult
                .thenAccept((result) -> System.out.println("Payment completed: %d".formatted(result)))
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

