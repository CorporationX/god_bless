package school.faang.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int THREAD_POOL = 5;

    private ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> futurePayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureData = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer dataResult =  futureData.get();
        Integer paymentResult =  futurePayment.get();
        System.out.println("Analytics sent: " + dataResult);
        System.out.println("Payment completed: " + paymentResult);
    }

    public void shutdown() {
        executorService.shutdown();
    }




}
