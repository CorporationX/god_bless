package school.faang.module4.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final long COLLECT_TIME_IN_MS = 10_000L;
    private static final long ANALYZE_TIME_IN_MS = 1_000L;
    private static final long TERMINATION_TIME_IN_S = 11L;
    private static final int THREAD_COUNT = 2;

    public int collectPayment() {
        try {
            Thread.sleep(COLLECT_TIME_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYZE_TIME_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_COUNT);
        CompletableFuture<Integer> collector = CompletableFuture.supplyAsync(this::collectPayment, executors);
        collector.thenAccept((sum) -> System.out.printf("payment collected: %d\n", sum));

        CompletableFuture<Integer> analyzer = CompletableFuture.supplyAsync(this::sendAnalytics, executors);
        analyzer.thenAccept((sum) -> System.out.printf("analytics sent: %d\n", sum));

        executors.shutdown();
        try {
            if (!executors.awaitTermination(TERMINATION_TIME_IN_S, TimeUnit.SECONDS)) {
                System.out.println("not all tasks done. force termination");
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
