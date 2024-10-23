package sprint_4.sprint_4_1_async_future.asyncAndFuture_38099;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
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
    private static final long WAIT_TIME_TERMINATION = 60;

    private final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS_POOL);

    public void doAll() {
        Future<Integer> paymentFuture =  executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture =  CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            int numAnalytic = analyticsFuture.join();
            LOG.info("Analytics sent: {}", numAnalytic);
        }catch (CompletionException e){
            LOG.warn("Analytics don't sent, error: {}", e.getMessage());
        }

        try {
            int payment = paymentFuture.get();
            LOG.info("Payment collected: {}", payment);
        } catch (InterruptedException | ExecutionException e) {
            LOG.warn("Payment don't collect, error: {}", e.getMessage());
        }

        executor.shutdown();
        try {
            if(!executor.awaitTermination(WAIT_TIME_TERMINATION, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                LOG.warn("Executor did not terminate in the specified time: {} seconds", WAIT_TIME_TERMINATION);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            LOG.warn("Executor interrupted during termination.");
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
