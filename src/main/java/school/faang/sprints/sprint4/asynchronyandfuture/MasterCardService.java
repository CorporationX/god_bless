package school.faang.sprints.sprint4.asynchronyandfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static final int COLLECT_PAYMENT_TIME_MILLIS = 10_000;
    public static final int SEND_ANALYTICS_MILLIS = 1_000;
    public static final int DEFAULT_PAYMENT = 10_000;
    public static final int DEFAULT_ANALYTICS = 1_000;

    ExecutorService executor = Executors.newFixedThreadPool(2);

    static int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_TIME_MILLIS);
            return DEFAULT_PAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread was interrupted while collect payment");
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_MILLIS);
            return DEFAULT_ANALYTICS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread was interrupted while send analytics");
        }
    }


    void doAll() {
        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        sendAnalyticsFuture.thenAccept(System.out::println);

        try {
            System.out.println(collectPaymentFuture.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread was interrupted or exception occurred during collect payment");
        }
    }
}
