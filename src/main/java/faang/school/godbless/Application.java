package faang.school.godbless;

import faang.school.godbless.data.service.MasterCard;
import faang.school.godbless.domain.service.CardService;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Application {

    private final static int POOL_SIZE = 2;
    private final static int AWAIT_THRESHOLD_SEC = 11;

    public static void main(String[] args) {
        System.out.println("Application started");

        long duration = measurement(Application::doAll);

        System.out.println("Execution time:" + duration + " ms");
    }

    private static void doAll() {
        CardService cardService = new MasterCard();

        var pool = Executors.newFixedThreadPool(POOL_SIZE);

        Future<Integer> paymentFuture = pool.submit(cardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(cardService::sendAnalytics, pool);

        analyticsFuture.thenAccept(analytics -> {
                    System.out.println("Analytics: " + analytics);
                    try {
                        int payment = paymentFuture.get(AWAIT_THRESHOLD_SEC, TimeUnit.SECONDS);
                        System.out.println("Payment: " + payment);
                    } catch (InterruptedException | ExecutionException | CancellationException | TimeoutException e) {
                        throw new RuntimeException(e);
                    }
                }).exceptionally(ex -> {
                    throw new RuntimeException(ex);
                })
                .join();

        pool.shutdown();
    }

    private static long measurement(Runnable task) {
        long startTime = System.nanoTime();

        task.run();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }
}