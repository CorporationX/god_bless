package faang.school.godbless.BJS213384;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int POOL_SIZE = 4;

    @SneakyThrows
    public static void main(String[] args) {
        doAll();
    }

    @SneakyThrows
    public static void doAll()   {
        MasterCardService masterCard = new MasterCardService("Stripe Integration");
        ExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);
        Future<Integer> futurePayment = executorService.submit(masterCard::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(masterCard::sendAnalytics, executorService);
        executorService.shutdown();
        System.out.println(futureAnalytics.get());
        System.out.println(futurePayment.get());
    }
}
