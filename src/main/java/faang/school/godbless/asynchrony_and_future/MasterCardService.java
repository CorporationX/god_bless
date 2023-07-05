package faang.school.godbless.asynchrony_and_future;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
@AllArgsConstructor
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentResult = executor.submit(() -> this.collectPayment());
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(() -> this.sendAnalytics());
        try {
            System.out.println(sendAnalyticsResult.get());
            System.out.println(collectPaymentResult.get());
            executor.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
