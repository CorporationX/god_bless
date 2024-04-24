package faang.school.godbless.Async.AsyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> collectedPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsCompetableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        try {
            Integer collectedPayment = collectedPaymentFuture.get();
            Integer analytics = analyticsCompetableFuture.get();

            System.out.println("Collect payment: " + collectedPayment);
            System.out.println("Analytics: " + analytics);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        } finally {
            executor.shutdown();
        }

    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
