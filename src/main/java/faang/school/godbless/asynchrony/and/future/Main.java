package faang.school.godbless.asynchrony.and.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final MasterCardService masterCardService = new MasterCardService();

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Integer> completableFutureOne = CompletableFuture.supplyAsync(
                () -> masterCardService.collectPayment(), executorService);
        CompletableFuture<Integer> completableFutureTwo = CompletableFuture.supplyAsync(
                () -> masterCardService.sendAnalystics(), executorService);
        int resultOne = completableFutureOne.get();
        int resultTwo = completableFutureTwo.get();

        executorService.shutdown();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }
}
