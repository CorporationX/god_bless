package faang.school.godbless.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static final int THREAD_COUNT = 4;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        doAll(executorService);
    }

    public static void doAll(ExecutorService executorService) {

        Future<Integer> futureCollectPayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFutureAnalystics =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalystics, executorService);

        Integer analysticsResult = completableFutureAnalystics.join();
        System.out.println(Thread.currentThread().getName() + " was executed. Analystics result: " + analysticsResult);

        try {
            Integer collectPaymentResult = futureCollectPayment.get();
            System.out.println(Thread.currentThread().getName() + " was executed. Collect payment result: " + collectPaymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
