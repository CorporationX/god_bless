package faang.school.godbless;

import java.util.concurrent.*;

public class Main {
    private static final MasterCardService masterCardService = new MasterCardService();
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        System.out.println("Hello Almas!");

        doAll();
    }

    public static void doAll() {
        Future<Integer> collectedPayment = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> sendedAnalytics = CompletableFuture.supplyAsync(masterCardService::sendAnalytics);

        try {
            int analyticsResult = sendedAnalytics.get();
            System.out.println("Analytics result: " + analyticsResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException("Analytics is interrupted", e);
        }

        // Затем ждем завершения collectPayment
        try {
            int paymentResult = collectedPayment.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException("Payment is interrupted", e);
        }
    }
}
