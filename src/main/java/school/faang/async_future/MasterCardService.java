package school.faang.async_future;


import java.util.concurrent.*;

public class MasterCardService {
    private static final long COLLECT_PAYMENT_TIME = 10000;
    private static final long SEND_ANALYTICS_TIME = 1000;

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> number = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> number2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            System.out.println("Analysis has been sent: " + number2.get());
            System.out.println("Payment completed: " + number.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_TIME);
            return (int) COLLECT_PAYMENT_TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_TIME);
            return (int) SEND_ANALYTICS_TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
