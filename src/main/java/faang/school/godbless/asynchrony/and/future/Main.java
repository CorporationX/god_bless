package faang.school.godbless.asynchrony.and.future;

import java.util.concurrent.*;

public class Main {
    private static final MasterCardService masterCardService = new MasterCardService();

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> futureOne = executorService.submit(
                masterCardService::collectPayment);
        CompletableFuture<Integer> completableFutureTwo = CompletableFuture.supplyAsync(
                masterCardService::sendAnalystics, executorService);

        executorService.shutdown();
        while(!futureOne.isDone() && !completableFutureTwo.isDone()) {
            System.out.println("Future: " + futureOne.get());
            System.out.println("CompletableFuture: " + completableFutureTwo.get());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }
}
