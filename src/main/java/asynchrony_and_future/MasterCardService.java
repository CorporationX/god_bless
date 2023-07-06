package asynchrony_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread, exception) ->
                System.out.println("Exception was thrown with message \"" + exception.getMessage()
                        + "\" in thread " + thread.getName());
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int resultFuture2 = future2.get();
            System.out.println("Analytics sent - " + resultFuture2);
            while (!future1.isDone()) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Waiting for collecting payment");
            }
            int resultFuture1 = future1.get();
            System.out.println("Payment collected - " + resultFuture1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw new RuntimeException("Something went wrong");
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
