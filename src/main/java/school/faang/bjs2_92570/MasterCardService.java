package school.faang.bjs2_92570;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int AMOUNT_FOR_PAYMENT = 5_000;
    private static final int AMOUNT_FOR_ANALYTICS = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return AMOUNT_FOR_PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return AMOUNT_FOR_ANALYTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int doAll(Supplier<Integer> collectPayment, Supplier<Integer> sendAnalytics) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> payFuture = executorService.submit(collectPayment.);
    }
}