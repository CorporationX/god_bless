package faang.school.godbless.asycnAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        try {
            doALl();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void doALl() throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentResult = executor.submit(masterCardService::collectPayment);
        CompletableFuture.supplyAsync(masterCardService::sendAnalystics, executor)
                .thenAccept(result -> System.out.println("Result form analytics: "+result));
        System.out.println("Result form payment: " +paymentResult.get());
        executor.shutdown();
    }
}
