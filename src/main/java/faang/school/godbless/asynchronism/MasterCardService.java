package faang.school.godbless.asynchronism;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> sentAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        Future<Integer> collectedPayment = executor.submit(this::collectPayment);

        try {
            System.out.println(sentAnalytics.get());
            System.out.println(collectedPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }

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
}
