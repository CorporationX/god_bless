package school.faang.sprint4.task_61888;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();

        EXECUTOR.shutdownNow();

        try {
            if (!EXECUTOR.awaitTermination(TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }


    public void doAll() {
        CompletableFuture.supplyAsync(this::sendAnalytics, EXECUTOR)
                .thenAccept(analytics -> System.out.println("Аналитика отправлена: " + analytics))
                .join();
        Future<Integer> i = EXECUTOR.submit(this::collectPayment);
        try {
            System.out.println("Платеж выполнен: " + i.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
