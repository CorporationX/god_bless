package faang.school.godbless.assynchronization;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int NUM_THREADS = 5;
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(NUM_THREADS);

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> payment = SERVICE.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics, SERVICE);
        while (!analytics.isDone()) {
            Thread.sleep(1000);
            System.out.println("Waining for the result of analytics ...");
        }
        System.out.println(analytics.get());
        System.out.println(payment.get());
        SERVICE.shutdown();
        SERVICE.awaitTermination(100, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
