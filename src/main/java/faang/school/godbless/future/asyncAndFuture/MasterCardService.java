package faang.school.godbless.future.asyncAndFuture;

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

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        try {
            while (!future1.isDone()) {
                System.out.println("sending analytics");
                TimeUnit.SECONDS.sleep(1);
                int analytics = future2.get();
                System.out.println("analytics result:" + analytics);
            }

            int payment = future1.get();

            System.out.println(payment + " - payment");

            executorService.shutdown();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
