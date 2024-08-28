package faang.school.godbless.BJS2_24935;

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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> resultCollectPayment = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> resultSendAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        System.out.println(resultSendAnalytics.get());
        System.out.println(resultCollectPayment.get());

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
