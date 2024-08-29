package faang.school.godbless.task.multithreading.async.async.and.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int ANALYTIC_SEND_TIME = 1_000;
    private static final int ANALYTIC_SEND_RETURN = ANALYTIC_SEND_TIME;
    private static final int PAYMENT_COLLECT_TIME = 10_000;
    private static final int PAYMENT_COLLECT_RETURN = PAYMENT_COLLECT_TIME;

    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private Future<Integer> payment;
    private CompletableFuture<Integer> analytics;

    public void doAll() {
        runTask();
        waitTaskResult();
    }

    private void runTask() {
        this.payment = executor.submit(this::collectPayment);
        this.analytics = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        executor.shutdown();
    }

    private void waitTaskResult() {
        log.info("Send analytics result: {}", getAnalytics());
        log.info("Collect payment result {}", paymentGet(payment));
    }

    private int getAnalytics() {
        return analytics.join();
    }

    private int paymentGet(Future<Integer> payment) {
        try {
            while(!payment.isDone()) {
            }
            return payment.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private int collectPayment() {
        log.info("CollectPayment");
        try {
            Thread.sleep(PAYMENT_COLLECT_TIME);
            return PAYMENT_COLLECT_RETURN;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        log.info("SendAnalytics");
        try {
            Thread.sleep(ANALYTIC_SEND_TIME);
            return ANALYTIC_SEND_RETURN;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
