package faang.school.godbless.ThirdSprint.BJS2_28026;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The End!!!");
    }

    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(() -> collectPayment());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sendAnalystics(), service);
        completableFuture.get();
        future.get();
        System.out.println("Done");
        service.shutdown();
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            System.out.println("collect");
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            System.out.println("send");
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
