package faang.school.godbless.multithreading.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(1000);
            return 3000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(3000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static void doALL() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> collectPaymentRes = executor.submit(MasterCardService::collectPayment);
        executor.shutdown();

        CompletableFuture<Integer> sendAnalyticsRes = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        System.out.println(sendAnalyticsRes.join());
        System.out.println(collectPaymentRes.get());

    }

    public static void main(String[] args) {
        try {
            doALL();
        } catch (ExecutionException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
