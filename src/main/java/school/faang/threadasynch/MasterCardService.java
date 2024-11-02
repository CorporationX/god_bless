package school.faang.threadasynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        Integer resultPayment = paymentFuture.get();
        System.out.println("The payment has bee done: " + resultPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("The analytics has been sent: " + analyticsResult);

    }
}
