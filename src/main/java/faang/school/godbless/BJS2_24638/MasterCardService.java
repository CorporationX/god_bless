package faang.school.godbless.BJS2_24638;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MasterCardService {
    private static final int COLLECT_PAYMENT_CONST = 1000;
    private static final int SEND_ANALYTICS_CONST = 10000;

    private final ExecutorService executor = Executors.newCachedThreadPool();

    private int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_CONST);
            return COLLECT_PAYMENT_CONST;
        } catch (InterruptedException e) {
            throw new RuntimeException("Collect Payment sleep error");
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_CONST);
            return SEND_ANALYTICS_CONST;
        } catch (InterruptedException e) {
            throw new RuntimeException("Send Analytics sleep error");
        }
    }

    public void doAll() {
        Future<Integer> collectPaymentResult = executor.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics, executor)
                .thenAccept(result -> System.out.println("Send Analytics has been completed. Result: " + result))
                .join();
        executor.shutdown();
        try {
            int result = collectPaymentResult.get();
            System.out.println("Collect Payment has been completed. Result: " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException("Async thread was interrupted");
        } catch (ExecutionException e) {
            throw new RuntimeException("Get result error");
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
