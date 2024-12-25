package school.faang.bjs249891;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        final long start = System.currentTimeMillis();
        System.out.println("main started");

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> payment = service.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        Integer analyticsResult = completableFuture.join();

        System.out.println("Analytics: " + analyticsResult);
        Integer paymentResult = payment.get();
        System.out.println("Payment: " + paymentResult);
        service.shutdown();
        System.out.println("main ended");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}
