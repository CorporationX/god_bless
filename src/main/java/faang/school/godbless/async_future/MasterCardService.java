package faang.school.godbless.async_future;

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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> compFuture = CompletableFuture.supplyAsync(() -> sendAnalystics());
        try {
            int compFutureInt = compFuture.get();
            System.out.println("Send analytics = " + compFutureInt);
            int futureInt = future.get();
            System.out.println("Collect payment = " + futureInt);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
