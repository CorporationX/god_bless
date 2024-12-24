package school.faang.task_49867;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(service::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(service::sendAnalytics);

        int analyticsResult = analyticsFuture.join();
        System.out.printf("Аналитика отправлена: %s%n", analyticsResult);

        try {
            int paymentResult = paymentFuture.get();
            System.out.printf("Платеж выполнен: %s%n", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
