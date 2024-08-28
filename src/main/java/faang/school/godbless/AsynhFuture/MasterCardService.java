package faang.school.godbless.AsynhFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentFuture = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsCompletableFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, service);

        System.out.println(sendAnalyticsCompletableFuture.get());

        System.out.println(collectPaymentFuture.get());

        service.shutdown();
        try {
            if (!service.awaitTermination(11_000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
