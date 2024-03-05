package faang.school.godbless.asynchronyfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("The payment was interrupted");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> resultPayment = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer>  resultAnalytics = CompletableFuture.supplyAsync(masterCardService::sendAnalystics);

        System.out.println(resultAnalytics.get());
        System.out.println(resultPayment.get());

        executorService.shutdown();
    }
}
