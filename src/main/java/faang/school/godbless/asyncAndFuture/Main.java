package faang.school.godbless.asyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        CompletableFuture<Integer> collectPaymentFuture = CompletableFuture.supplyAsync(MasterCardService::collectPayment, executor);

        sendAnalyticsFuture.join();
        System.out.println("Результат sendAnalytics: " + sendAnalyticsFuture.get());

        collectPaymentFuture.join();
        System.out.println("Результат collectPayment: " + collectPaymentFuture.get());

        executor.shutdown();
    }
}