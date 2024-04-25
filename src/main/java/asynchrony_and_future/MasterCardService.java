package asynchrony_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll(ExecutorService executorService) throws ExecutionException, InterruptedException {
        Future<Integer> futurePayment = executorService.submit(() -> collectPayment());
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(() -> sendAnalytics());

        try {
            futurePayment.get();
            futureAnalytics.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(futurePayment.get());
        futureAnalytics.thenAccept(System.out::println);
    }

    private int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(2_500);
            return 5_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
