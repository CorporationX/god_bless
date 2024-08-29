package faang.school.godbless.task24871;

import java.util.concurrent.*;

public class MasterCardService {
    private ExecutorService pool = Executors.newFixedThreadPool(3);
    public int collectPayment(){
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public int sendAnalytics(){
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> future = pool.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics);
        int resultAnalytics = completableFuture.get();
        int resultPayment = future.get();
    }
}
