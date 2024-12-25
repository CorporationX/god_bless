package school.faang.async_future;

import java.util.concurrent.*;

public class MasterCardService {

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> number = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> number2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            System.out.println("Analysis has been sent: " + number2.get());
            System.out.println("Payment completed: " + number.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
