package faang.school.godbless.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterClassService {

    public static int collectPayment() {
        try {
            System.out.println("Payment started");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            System.out.println("Analytics started");
            Thread.sleep(1_000);
            System.out.println("Analytics ended");
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int calculate(int num) {
        return num + 1;
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = service.submit(MasterClassService::collectPayment);

        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterClassService::sendAnalytics);
//
        int sendAnalyticsResult = collectPaymentFuture.get();
        System.out.println("Analytics sent");
        int collectPaymentResult = sendAnalyticsFuture.get();
        System.out.println("Payment collected");

        service.shutdown();
    }
}
