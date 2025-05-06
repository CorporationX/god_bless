package school.faang.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10000;
    private static final int ONE_SECOND_IN_MS = 1000;
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);


        try {
            int analyticsResult = analyticsFuture.get();
            System.out.printf("Аналитика отправлена: %d%n", analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.printf("Платеж выполнен: %d%n", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
