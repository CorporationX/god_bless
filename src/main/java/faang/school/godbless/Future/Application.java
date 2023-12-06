package faang.school.godbless.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            doAll(executor, new MasterCardService());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void doAll(ExecutorService executor, MasterCardService masterCardService) throws ExecutionException, InterruptedException {

        Future<Integer> payment = executor.submit(() -> masterCardService.collectPayment());
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(() -> masterCardService.sendAnalytics());

        while (!analytics.isDone()) {

        }

        System.out.println(analytics.get());

        while (!payment.isDone()) {

        }

        System.out.println(payment.get());
    }
}
