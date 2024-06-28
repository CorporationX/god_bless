package faang.school.godbless.asynchronyAndTheFuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        System.out.println(doAll(masterCardService));
    }

    @SneakyThrows
    public static int doAll(MasterCardService cardService) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer> future = executor.submit(cardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(cardService::sendAnalytics, executor);

        int result = completableFuture.get();
        result += future.get();

        executor.shutdown();
        return result;
    }
}
