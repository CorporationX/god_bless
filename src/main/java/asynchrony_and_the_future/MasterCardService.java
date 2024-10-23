package asynchrony_and_the_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final ExecutorService service = Executors.newFixedThreadPool(2);
    private static final int TIME_AWAIT = 30;

    /**
     * Collects payment from the user in a separate thread.
     *
     * @return the payment amount, in cents
     */
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Sends analytics data to the server in a separate thread.
     *
     * @return the analytics data size, in bytes
     */
    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Does both payment collection and analytics sending in parallel, then waits
     * for both tasks to finish and prints the results.
     *
     * @throws ExecutionException if either the payment collection or analytics
     *                             sending tasks throw an exception
     * @throws InterruptedException if the thread is interrupted while waiting
     *                              for tasks to finish
     */
    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> payment = service.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, service);

        int resultPayment = payment.get();
        int resultAnalytics = analytics.get();

        System.out.println("Аналитика отправлена: " + resultAnalytics);
        System.out.println("Платеж выполнен: " + resultPayment);

        service.shutdown();

        if (!service.awaitTermination(TIME_AWAIT, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
