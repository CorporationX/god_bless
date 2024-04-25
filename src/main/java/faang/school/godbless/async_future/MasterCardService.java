package faang.school.godbless.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        sendAnalyticsFuture.thenAccept(result -> System.out.println("Результат sendAnalytics: " + result)).join();

        try {
            int collectPaymentResult = collectPaymentFuture.get();
            System.out.println("Результат collectPayment: " + collectPaymentResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        doAll();
    }
}
