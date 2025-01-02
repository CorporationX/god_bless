package school.faang.sprint_4.task_49968;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executor.submit(masterCardService::collectPayment);

        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(
            masterCardService::sendAnalytics);

        System.out.println("Аналитика отправлена:" + analytics.join());
        System.out.println("Платеж выполнен: " + payment.get());
        executor.shutdown();
    }
}
