package faang.school.godbless.async_future;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
@AllArgsConstructor
public class Stripe {
    private MasterCardService masterCardService;

    public void doAll(ExecutorService executorService) {
        long startTime = System.currentTimeMillis();

        Future<Integer> paymentCollection =
                executorService.submit(() -> masterCardService.collectPayment());

        CompletableFuture<Integer> sentAnalytics =
                CompletableFuture.supplyAsync(() -> masterCardService.sendAnalytics(), executorService);

        System.out.println(getValue(paymentCollection));
        System.out.println("Main waited until payment will be collected: " + (System.currentTimeMillis() - startTime));

        System.out.println(getValue(sentAnalytics));
        System.out.println("Main waited until analytics will be sent: " + (System.currentTimeMillis() - startTime));
    }

    private <V> V getValue(Future<V> futureValue) {
        try {
            return futureValue.get();
        } catch (ExecutionException e) {
            throw new RuntimeException("Trying to get CANCELLED asynchronous calculation: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException("Trying to get INTERRUPTED asynchronous calculation: " + e.getMessage());
        }
    }
}
