package school.faang.task_49902;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    public static void main(String[] args) {
        try {
            doAll();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<String> sendAnalyticFuture = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics);
        executor.shutdown();

        String analyticResult = sendAnalyticFuture.join();
        log.info("Аналитика отправлена: {}", analyticResult);

        Integer collectResult = collectFuture.get();
        log.info("Платеж выполнен: {}", collectResult);
    }
}
