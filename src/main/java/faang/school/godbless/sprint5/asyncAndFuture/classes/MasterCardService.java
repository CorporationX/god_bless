package faang.school.godbless.sprint5.asyncAndFuture.classes;

import java.util.concurrent.*;

public class MasterCardService {

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyst = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        try {
            System.out.println(analyst.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (!payment.isDone()) {
            System.out.println("Waiting for payment...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int paymentResult = 0;

        try {
            paymentResult = payment.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Payment result: " + paymentResult);

        executor.shutdown();
    }
}