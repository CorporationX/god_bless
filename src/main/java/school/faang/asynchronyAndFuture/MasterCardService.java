package school.faang.asynchronyAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private final int THREAD_POOL_SIZE = 5;

    private final int timeOfCollectPayment = 10_000;
    private final int timeOfSendAnalytics = 1_000;

    private int collectPayment() {

        try {
            Thread.sleep(timeOfCollectPayment);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Failed to collect payment " + e.getMessage(), e);
        }
        return 10_000;
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(timeOfSendAnalytics);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Failed to send analytics " + e.getMessage(), e);
        }
        return 1_000;
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<Integer> future = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);

        try {
            System.out.printf("аналитика отправлена: %s\n", completableFuture.get());
            System.out.printf("Платеж выполнен: %s\n", future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Thread was interrupted while waiting result: " + e.getMessage(), e);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdown();
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new IllegalStateException("Thread was interrupted while waiting all threads: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
