package school.faang.bjs2_92581;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int FIXED_PAYMENT_INFO = 5_000;
    private static final int FIXED_ANALYTICS_INFO = 17_000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return FIXED_PAYMENT_INFO;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при обработке платежа, операция прервана", e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return FIXED_ANALYTICS_INFO;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при отправке аналических данных, операция прервана", e);
        }
    }

    public void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        try {
            Integer sendResult = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytics, executor)
                            .get();
            System.out.printf("Аналитика отправлена: %s%n", sendResult);

            int paymentResult = paymentFuture.get();
            System.out.printf("Платеж выполнен: %s%n", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            System.out.println("Что-то прервало операцию, не завершено.");
        } finally {
            executor.shutdown();
        }
    }
}
