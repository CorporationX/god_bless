package school.faang.stream4.asyncandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public static final int NUMBER_OF_THREADS = 2;
    public static final int TERMINATION_TIMEOUT = 30;
    public static final ExecutorService POOL = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService.doAll();

        terminateExecutorService();
    }

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private static void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> payment = POOL.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, POOL);

        Integer calculatedAnalytics = analytics.join();
        System.out.printf("Аналитика отправлена: %d\n", calculatedAnalytics);

        Integer calculatedPayment = payment.get();
        System.out.printf("Платеж выполнен: %d\n", calculatedPayment);
    }

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }


    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void terminateExecutorService() {
        MasterCardService.POOL.shutdown();

        try {
            if (!MasterCardService.POOL.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                MasterCardService.POOL.shutdownNow();
            }
        } catch (InterruptedException e) {
            MasterCardService.POOL.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
