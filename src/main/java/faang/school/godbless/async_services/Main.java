package faang.school.godbless.async_services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService() {
            final ExecutorService executor = Executors.newFixedThreadPool(2);

            @Override
            public void doAll() throws ExecutionException, InterruptedException {
                super.doAll();
                Future<Integer> collectPayment = executor.submit(MasterCardService::collectPayment);
                CompletableFuture<Integer> sendAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
                System.out.println("Future and returned value:  " + collectPayment.get());
                System.out.println("CompletableFuture returned value: " + sendAnalytics.get());
                executor.shutdown();
            }
        };
        service.doAll();
    }
}

