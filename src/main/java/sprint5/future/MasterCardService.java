package sprint5.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(1);

    public static String doAll() {
        int analyticsResult;
        int paymentsResult;

        Future<Integer> payment = SERVICE.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        SERVICE.shutdown();

        analyticsResult = waitForResultOfAnalysis(analytics);
        paymentsResult = waitForResultOfPayment(payment);

        return String.format("Analytics: %d; Payment: %d", analyticsResult, paymentsResult);
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int waitForResultOfPayment(Future<Integer> payment) {
        try {
            return payment.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("It was not possible to collect payment");
        }
    }

    private static int waitForResultOfAnalysis(CompletableFuture<Integer> analytics) {
        try {
            return analytics.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("No analysis could be carried out");
        }
    }
}
