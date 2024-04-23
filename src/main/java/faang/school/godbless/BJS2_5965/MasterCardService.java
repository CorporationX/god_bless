package faang.school.godbless.BJS2_5965;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(3000);
            return 1;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(5000);
            return 2;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> completableFutureSendAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        while (!futureCollectPayment.isDone()) {
            System.out.println("ждем 1 поток");
        }

        while (!completableFutureSendAnalytics.isDone()) {
            System.out.println("ждем 2 поток");
        }

        Integer result2 = futureCollectPayment.get();
        Integer result1 = completableFutureSendAnalytics.get();

        System.out.println("sendAnalytics = " + result1);
        System.out.println("collectPayment = " + result2);
    }
}
