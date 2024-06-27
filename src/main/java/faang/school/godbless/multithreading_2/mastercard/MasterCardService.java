package faang.school.godbless.multithreading_2.mastercard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {
    public static int collectPayment() {
        int payment = 10_000;
        return sleepAndGetValue(payment);
    }

    public static int sendAnalystics() {
        int valueForAnalytics = 1_000;
        return sleepAndGetValue(valueForAnalytics);
    }

    public static int sleepAndGetValue(int value) {
        try {
            Thread.sleep(value);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        System.out.println("Результат collectPayment: " + future.get(15, TimeUnit.SECONDS));
        System.out.println("Результат sendAnalystics: " + completableFuture.get(15, TimeUnit.SECONDS));
        executor.shutdown();

    }
}
