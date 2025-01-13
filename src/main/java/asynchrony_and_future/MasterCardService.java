package asynchrony_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void doAll(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> paymentFuture = CompletableFuture.supplyAsync(MasterCardService::collectPayment, executorService)
                .thenAcceptAsync(result -> System.out.println("Платеж: " + result), executorService);


        CompletableFuture<Void> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService)
                .thenAcceptAsync(result -> System.out.println("Аналитика: " + result),executorService);

        CompletableFuture.allOf(paymentFuture,analyticsFuture).join();
        executorService.shutdown();
    }
}
