package faang.school.godbless.AsynchronyAndFuture;

import java.util.concurrent.*;

public class Card extends MasterCardService {
    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        int resultSendAnalystics = completableFuture.get();
        System.out.println("Результа операции sendAnalystics: " + resultSendAnalystics);
        int resultCollectPayment = future.get();
        System.out.println("Результа операции collectPayment: " + resultCollectPayment);

        executorService.shutdown();

    }
}
