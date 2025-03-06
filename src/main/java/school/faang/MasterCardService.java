package school.faang;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void doAll() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(()
                -> MasterCardService.collectPayment());
        CompletableFuture<Integer> analytycsFutere = CompletableFuture.supplyAsync(()
                -> MasterCardService.sendAnalytics());

        int analytycsResult = analytycsFutere.get();
        System.out.println("Результат аналитики отправлен за " + analytycsResult / 1000 + " секунд.");

        int paymentResult = paymentFuture.get();
        System.out.println("Оплата прошла за " + paymentResult / 1000 + " секунд.");
    }

}

