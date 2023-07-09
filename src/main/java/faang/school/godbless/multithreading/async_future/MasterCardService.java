package faang.school.godbless.multithreading.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(1000);
            return 3000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(3000);
            return 1000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> collectPaymentRes = executor.submit(MasterCardService::collectPayment);
        executor.shutdown();

        CompletableFuture<Integer> sendAnalyticsRes = CompletableFuture.supplyAsync(this::sendAnalytics);

        System.out.println(sendAnalyticsRes.join());
        try {
            System.out.println(collectPaymentRes.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
    }
}
