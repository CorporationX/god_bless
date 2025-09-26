package school.faang.bjs2_92538;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_COLLECTION = 5_000;
    private static final int ANALYSIS = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_COLLECTION;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYSIS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static void doAll(ExecutorService executor) {
        CompletableFuture.supplyAsync(() -> MasterCardService.sendAnalytics(), executor)
                .thenAccept((result) -> System.out.println(result));
        Future<Integer> paymentResult = executor.submit(() -> MasterCardService.collectPayment());

        try {
            System.out.println(paymentResult.get());
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
