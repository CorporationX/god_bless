package school.faang.task_49868;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futurePayment = executor.submit(() -> MasterCardService.collectPayment());
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(() ->
                MasterCardService.sendAnalytics());

        Integer resultAnalytics = futureAnalytics.join();
        System.out.println("Результат аналитики: " + resultAnalytics);

        try {
            Integer resultPayment = futurePayment.get();
            System.out.println("Резултат платежа " + resultPayment);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
