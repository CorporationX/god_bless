package faang.school.godbless.AsynchronousAndFuture;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class MasterCardService {
    private static final int NUM_THREADS = 3;
    private static final ExecutorService EXECUTE = Executors.newFixedThreadPool(NUM_THREADS);

    public void doAll(){
        Future<Integer> payment = EXECUTE.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, EXECUTE);

        try {
            log.info("Analytics: " + analytics.get());
        } catch (InterruptedException e) {
            throw new RuntimeException("thread that running CompletableFuture<Integer> analytics was interrupted " + e);
        } catch (ExecutionException e) {
            throw new RuntimeException("collectAnalytics method completed with exception " + e);
        }

        try {
            log.info("Payment: " + payment.get());
        } catch (InterruptedException e) {
            throw new RuntimeException("thread that running Future<Integer> payment was interrupted " + e);
        } catch (ExecutionException e) {
            throw new RuntimeException("collectPayment method completed with exception " + e);
        }

        EXECUTE.shutdown();
        try {
            EXECUTE.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(".awaitTermination() in doAll was interrupted while waiting " + e);
        }
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("thread in collectPayment was interrupted while sleeping");
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("thread in collectPayment was interrupted while sleeping");
        }
    }
}