package faang.school.godbless.asynch_future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();

        masterCardService.doAll();
    }

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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService poolThreads = Executors.newFixedThreadPool(1);

        Future<Integer> future = poolThreads.submit(() -> collectPayment());
        CompletableFuture<Integer> compFuture = CompletableFuture.supplyAsync(
                () -> sendAnalystics(), poolThreads);

        System.out.println(future.get());
        System.out.println(compFuture.get());

        poolThreads.shutdown();
    }
}
