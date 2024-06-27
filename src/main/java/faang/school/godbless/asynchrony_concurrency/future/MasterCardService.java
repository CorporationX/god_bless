package faang.school.godbless.asynchrony_concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {

    public static final int TIME_ANALYSTIC = 1000;

    private static final int TIME_PAYMENT = 10000;

    public static int collectPayment() {
        return wait(TIME_PAYMENT);
    }

    public static int sendAnalystics() {
        return wait(TIME_ANALYSTIC);
    }

    public static int wait(int time) {
        try {
            Thread.sleep(time);
            return time;
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