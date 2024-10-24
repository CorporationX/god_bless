package school.faang.asynchrony.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private final long WAITING_TIME = 10000;
    private final int SUM = 10000;
    private final int THREAD_NUMBER = 2;
    private final int TIME_TO_FINISH = 1;

    public int collectPayment() {
        try {
            Thread.sleep(WAITING_TIME);
            return SUM;
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
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);
        Future<Integer> resultFromPayment = executor.submit(this::collectPayment);
        CompletableFuture<Integer> resultSendingAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        Integer analyticsResult = resultSendingAnalytics.join();
        System.out.println("Analytics sent: " + analyticsResult);

        try {
            Integer paymentResult = resultFromPayment.get();
            System.out.println("Payment processed: " + paymentResult);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIME_TO_FINISH, TimeUnit.MINUTES)) {
                System.out.println("All tasks finished");
            } else {
                System.out.println("Not all tasks finished");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

