package school.faang.Sprints.Multithreading_Async.asynchrony_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());

        Integer sendResult = sendAnalyticsFuture.join();
        System.out.println("Analytics was sent " + sendResult);
        try {
            Integer collectResult = collectPaymentFuture.get();
            System.out.println("Payment is completed " + collectResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

}
