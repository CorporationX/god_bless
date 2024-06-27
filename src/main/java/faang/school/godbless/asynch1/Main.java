package faang.school.godbless.asynch1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(masterCardService::collectPayment);
        CompletableFuture.supplyAsync(masterCardService::sendAnalytics)
                .thenAccept(System.out::println);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
