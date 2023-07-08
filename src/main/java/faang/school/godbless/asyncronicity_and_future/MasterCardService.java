package faang.school.godbless.asyncronicity_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> collectedPayment = service.submit(this::collectPayment);
        CompletableFuture<Integer> sentAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        sentAnalytics.thenAccept(result -> System.out.println("Analytics result: " + result));

        try {
            System.out.println("Collected payment result: " + collectedPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
    }
}
