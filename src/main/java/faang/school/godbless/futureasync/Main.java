package faang.school.godbless.futureasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        Future<Integer> paymentData = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> analyticsData = CompletableFuture.supplyAsync(masterCardService::sendAnalytics);
        System.out.println(analyticsData.join());
        System.out.println(getFuture(paymentData));

        executorService.shutdown();
        awaitTermination(executorService, 5L);
    }

    private static void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static <T> T getFuture(Future<T> future) throws RuntimeException {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}