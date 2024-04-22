package faang.school.godbless.AsyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer> collect = pool.submit(this::collectPayment);
        CompletableFuture<Integer> send = CompletableFuture.supplyAsync(this::sendAnalytics, pool);
        send.thenAccept(result -> System.out.println("sendAnalytics: " + result));
        send.join();
        System.out.println("collectPayment: " + collect.get());
        pool.shutdown();
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
