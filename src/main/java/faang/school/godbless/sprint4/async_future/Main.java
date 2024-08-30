package faang.school.godbless.sprint4.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        try {
            doAll();
        } catch(ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Received analytics: " + analytics.join());
        while(!payment.isDone()) {
            // Do something...
        }
        System.out.println("Received payment: $" + payment.get());
        executor.shutdown();
    }
}
