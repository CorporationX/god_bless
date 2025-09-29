package school.faang.bjs2_92555;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static final int THREAD_AMOUNT = 2;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        log.debug("Запускаем все Future.");
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsCompletableFuture = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, executor);
        int payment = paymentFuture.get();
        int analytics = analyticsCompletableFuture.get();
        log.debug("Платеж выполнен: {}", payment);
        log.debug("Аналитика отправлена: {}", analytics);
    }
}
