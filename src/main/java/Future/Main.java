package Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
        System.out.println("Main is over");
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPayment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println(sendAnalytics.join());
        while (!collectPayment.isDone())
            System.out.println(collectPayment.get());
        executor.shutdown();
    }
}