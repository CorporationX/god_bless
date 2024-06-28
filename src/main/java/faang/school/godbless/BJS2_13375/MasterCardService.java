package faang.school.godbless.BJS2_13375;

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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> collectedPayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService)
                        .thenAccept(analytics -> System.out.println("Analytics: " + analytics))
                                .join();

        System.out.println("Collected payment: " + collectedPayment.get());

        executorService.shutdown();

    }

}
