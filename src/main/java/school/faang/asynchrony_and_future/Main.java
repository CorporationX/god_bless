package school.faang.asynchrony_and_future;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();

        CompletableFuture<Integer> paymentFuture = service.collectPaymentAsync();
        CompletableFuture<Integer> analyticsFuture = service.sendAnalyticsAsync();

        try {
            analyticsFuture.thenAccept(result ->
                    MasterCardService.logger.info("Аналитика отправлена: {}", result)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        paymentFuture.thenAccept(result ->
                MasterCardService.logger.info("Платеж выполнен: {}", result)
        );

        CompletableFuture.allOf(paymentFuture, analyticsFuture).join();
    }
}