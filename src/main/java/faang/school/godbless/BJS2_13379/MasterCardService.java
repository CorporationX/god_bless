package faang.school.godbless.BJS2_13379;

import java.util.concurrent.*;

public class MasterCardService {

    private static ExecutorService executor = Executors.newFixedThreadPool(5);

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

    public static void doAll() {
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        int analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics).join();
        System.out.println(analytics);
        try {
            System.out.println(payment.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        doAll();
        executor.shutdown();
    }
}
