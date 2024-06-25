package faang.school.godbless;

import faang.school.godbless.data.service.MasterCard;
import faang.school.godbless.domain.service.CardService;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

    private final static int POOL_SIZE = 2;

    public static void main(String[] args) {
        long duration = measurement(() -> doAll());

        System.out.println("Execution time:" + duration + " ms");
    }

    private static void doAll() {
        CardService cardService = new MasterCard();

        try (var pool = Executors.newFixedThreadPool(POOL_SIZE)) {

            Future<Integer> paymentFuture = pool.submit(cardService::collectPayment);

            CompletableFuture.supplyAsync(cardService::sendAnalytics, pool)
                    .thenAccept(analytics -> {
                        System.out.println("Analytics:" + analytics);
                        try {
                            int payment = paymentFuture.get();
                            System.out.println("Payment:" + payment);
                        } catch (InterruptedException | ExecutionException | CancellationException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long measurement(Runnable task) {
        long startTime = System.nanoTime();

        task.run();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }
}