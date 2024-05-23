package faang.school.godbless.multithreading_async.BJS2_6510;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private int collectPayment() {
        try {
            Thread.sleep(5000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(7000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void doAll () throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futurePayment = executor.submit(this::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        while (!futurePayment.isDone()) {
            System.out.println("Waiting for the payment...");
        }

        while (!futureAnalytics.isDone()) {
            System.out.println("Waiting for the Analytics sending...");
        }

        Integer result2 = futurePayment.get();
        Integer result1 = futureAnalytics.get();

        System.out.println("sendAnalytics = " + result1);
        System.out.println("collectPayment = " + result2);
    }
}
