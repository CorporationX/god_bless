package faang.school.godbless.payments;

import java.util.concurrent.*;

public class MasterCardService {
    private static int collectPayment() {
        try {
            System.out.println("Started collecting payment");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            System.out.println("Collecting payment failed");
        }
        return 0;
    }

    private static int sendAnalytics() {
        try {
            System.out.println("Started sending analytics");
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.out.println("Sending analytics failed");
        }
        return 0;
    }

    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> payment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        int analyticsResult = analytics.get(1, TimeUnit.MINUTES);
        System.out.println("Analytics result: " + analyticsResult);

        int paymentResult = payment.get(1, TimeUnit.MINUTES);
        System.out.println("Payment result: " + paymentResult);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        doAll();
    }
}
