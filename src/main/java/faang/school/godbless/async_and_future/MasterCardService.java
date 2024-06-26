package faang.school.godbless.async_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> collectPaymentFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalyticsCompletableFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        System.out.println(sendAnalyticsCompletableFuture.get());
        System.out.println(collectPaymentFuture.get());

        executorService.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
