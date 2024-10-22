package sprint_4.sprint_4_1_async_future.asyncAndFuture_38099;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final Logger LOG = LoggerFactory.getLogger(MasterCardService.class);
    private static final long WAIT_TIME_COLLECT_PAYMENT = 10_000;
    private static final long WAIT_TIME_SEND_ANALYTICS = 1_000;
    private static final int COUNT_THREADS_POOL = 2;

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS_POOL);
        Future<Integer> future_1 =  executor.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(num -> LOG.info("Analytics sent: {}", num));

        try {
            int payment = future_1.get();
            LOG.info("Payment collected: {}", payment);
        } catch (InterruptedException | ExecutionException e) {
            LOG.warn("Payment don't collect, error: {}", e.getMessage());
        }

        executor.shutdown();
        try {
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                LOG.info("MasterCardService is completed");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public int collectPayment() {
        sleepThread(WAIT_TIME_COLLECT_PAYMENT);
        return 10_000;
    }

    public int sendAnalytics() {
        sleepThread(WAIT_TIME_SEND_ANALYTICS);
        return 1_000;
    }

    private void sleepThread(long wait_time) {
        try {
            Thread.sleep(wait_time);
        } catch (InterruptedException e) {
            LOG.warn("Thread is dead: {}", e.getMessage());
        }
    }
}
