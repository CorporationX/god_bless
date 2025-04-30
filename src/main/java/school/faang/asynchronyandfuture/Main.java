package school.faang.asynchronyandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) throws Exception {
        doAll();
    }

    public static void doAll() throws Exception {
        MasterCardService masterCardService = new MasterCardService();
        Future<Integer> collectPaymentFuture = executor.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyzeFuture =
                CompletableFuture.supplyAsync(masterCardService::sendAnalyze, executor);
        while (!collectPaymentFuture.isDone()) {
            System.out.println("Some logic here while collectPaymentFuture executing...");
        }
        System.out.printf("The collect payment result: %d\n\n", collectPaymentFuture.get());

        while (!sendAnalyzeFuture.isDone()) {
            System.out.println("Some logic here while sendAnalyzeFuture executing...");
        }
        System.out.printf("The send analyze result: %d\n", sendAnalyzeFuture.get());

        executor.shutdown();
        if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Shutting down executor...");
            executor.shutdownNow();
        }
    }
}
