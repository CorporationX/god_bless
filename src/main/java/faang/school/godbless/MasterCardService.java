package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        try {
            System.out.println(sendResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(collectResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        sendResult.join();
    }
    public static void main(String[] args) {
        doAll();
    }

}
