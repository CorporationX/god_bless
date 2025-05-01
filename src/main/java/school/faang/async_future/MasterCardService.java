package school.faang.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int TIME_TO_TERMINATE = 30;

    private int collectPayment(int paymentAmount) {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            System.out.println("Payment collected.");
            return paymentAmount;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics(int analyticsAmount) {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            System.out.println("Analytics sent.");
            return analyticsAmount;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll(int paymentAmount, int analyticsAmount) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = service.submit(() -> collectPayment(paymentAmount));
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(() -> sendAnalytics(analyticsAmount));

        try {
            int payment = paymentFuture.get();
            System.out.println("Payment collected: " + payment);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        int analytics = analyticsFuture.join();
        System.out.println("Analytics sent: " + analytics);

        shutdownExecutor(service);
    }

    private static void shutdownExecutor(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_TO_TERMINATE, TimeUnit.SECONDS)) {
                System.out.println("Executor did not terminate in the specified time.");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            System.out.println("Executor was forcibly shut down.");
        }
    }
}