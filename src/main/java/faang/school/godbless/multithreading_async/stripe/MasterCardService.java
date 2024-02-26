package faang.school.godbless.multithreading_async.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

    public static void doAll() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectFutureResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFutureResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        System.out.println(analyticsFutureResult.get(30, TimeUnit.SECONDS));
        System.out.println(collectFutureResult.get(30, TimeUnit.SECONDS));

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        doAll();
    }

}
