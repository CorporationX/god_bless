package faang.school.godbless.future.asyncAndFuture;

import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

public class MasterCardService {

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytic() {
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

        Future<Integer> future1 = executorService.submit(this::collectPayment);
        executorService.shutdown();
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(this::sendAnalytic);

        try {
            while (!future1.isDone()) {
                System.out.println("sending analytics");
                TimeUnit.SECONDS.sleep(1);
                int analytics = future2.get();
                System.out.println("analytics result:" + analytics);
            }

            int payment = future1.get();

            System.out.println(payment + " - payment");

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
