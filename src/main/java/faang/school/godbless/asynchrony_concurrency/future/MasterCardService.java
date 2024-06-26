package faang.school.godbless.asynchrony_concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll(ExecutorService executor) throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> futurePayment = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> futureAnalystics = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics, executor);

        int realPayment = futurePayment.get(11, TimeUnit.SECONDS);

        futureAnalystics.thenAccept(a -> System.out.println("analystics: " + a + " payment " + realPayment));

    }
}
