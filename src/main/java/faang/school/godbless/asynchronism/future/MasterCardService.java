package faang.school.godbless.asynchronism.future;

import java.util.concurrent.*;

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

    public static String doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer resultPayment = payment.get();
        Integer resultAnalytics = analytic.get();
        return "Analytics " + resultPayment + "Payment " + resultAnalytics;
    }
}
