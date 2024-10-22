package school.faang.async_future_BJS2_38007;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    private int collectPayment() {
        final int TIME_EXECUTION_PAYMENT = 10_000;
        try {
            Thread.sleep(TIME_EXECUTION_PAYMENT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return TIME_EXECUTION_PAYMENT;
    }

    private int sendAnalytics() {
        final int TIME_EXECUTION_ANALYTICS = 1000;
        try {
            Thread.sleep(TIME_EXECUTION_ANALYTICS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return TIME_EXECUTION_ANALYTICS;
    }

    public void doAll() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> paymentResult = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsResult = CompletableFuture.
                supplyAsync(this::sendAnalytics, executorService);

        executorService.shutdown();

        try {
            System.out.println("Analytics has sent: " + analyticsResult.get());
            System.out.println("Payment complete: " + paymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
