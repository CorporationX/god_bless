package faang.school.godbless.kxnvg.asynchronyandfuter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(100);
            return 100;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();

       Future<Integer> futureFromCollectPayment = service.submit(() -> collectPayment());
        CompletableFuture<Integer> futureFromSendAnalytics = CompletableFuture.supplyAsync(() -> sendAnalytics());
        System.out.println(futureFromSendAnalytics.join());

        try {
            System.out.println(futureFromCollectPayment.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
    }
}
