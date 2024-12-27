package school.faang.task_49876;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final long THREAD_COLLECT = 10_000;
    private static final long THREAD_ANALYTIC = 1_000;
    private static final int VALUE_COLLECT = 10_000;
    private static final int VALUE_ANALYTIC = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(THREAD_COLLECT);
            return VALUE_COLLECT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(THREAD_ANALYTIC);
            return VALUE_ANALYTIC;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> resultFutureAnalytic = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer resultAnalytics = resultFutureAnalytic.join();
        System.out.println(String.format("Result's of analytic = %d", resultAnalytics));

        Future<Integer> resultFutureCollect = service.submit(() -> collectPayment());
        try {
            Integer resultCollect = resultFutureCollect.get();
            System.out.println(String.format("Result's of collecting payments = %d", resultCollect));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
