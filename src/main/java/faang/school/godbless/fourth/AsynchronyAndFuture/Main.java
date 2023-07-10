package faang.school.godbless.fourth.AsynchronyAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        doALL();
    }

    public static void doALL() {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> futureResult1 = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureResult2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics,
                service);

        int result = futureResult2.join();
        System.out.println(result);

        try {
            result = futureResult1.get();
            System.out.println(result);

            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Thread has been interrupted");
        }
    }
}
