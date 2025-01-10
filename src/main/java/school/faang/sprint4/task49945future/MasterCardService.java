package school.faang.sprint4.task49945future;

import java.util.concurrent.*;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(() -> collectPayment());
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> sendAnalytics());

        int result1 = future2.get();
        System.out.println(result1);

        int result2 = future1.get();
        System.out.println(result2);

        executorService.shutdown();
    }
}
