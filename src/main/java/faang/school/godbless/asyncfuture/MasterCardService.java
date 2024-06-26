package faang.school.godbless.asyncfuture;

import java.util.concurrent.*;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> payment = service.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        analytics
                .thenApply(r->r+2_000)
                .thenRun(()->{
                    try {
                        int res = payment.get();
                        System.out.println("res is "+res);
                        service.shutdown();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
