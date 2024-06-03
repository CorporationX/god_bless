package faang.school.godbless.BJS2_6062;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

public class MasterCardService {
    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalysticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        sendAnalysticsFuture.thenAccept(futureResult -> System.out.println("Result of analytics sending: " + futureResult));

        while(!collectPaymentFuture.isDone()) {
            System.out.println("Waiting for analytics sending...");
        }
        try {
            System.out.println("Payment result: " + collectPaymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
