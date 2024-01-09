package faang.school.godbless.alexbulgakoff.multithreading.async.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Alexander Bulgakov
 */

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectPayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalytics =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);


        int collect = collectPayment.get();
        int analytics = sendAnalytics.get();

        executorService.shutdown();

        System.out.println("analytics is: " + analytics);
        System.out.println("collect is: " + collect);

    }
}
