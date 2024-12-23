package school.faang.task_49880;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private final static int PAYMENT = 10_000;
    private final static int ANALYTICS = 1000;
    private final static int SLEEP_WAIT = 2000;
    private static final Logger log = LoggerFactory.getLogger(MasterCardService.class);

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT);
            return PAYMENT;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS);
            return ANALYTICS;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> thread = executor.submit(MasterCardService::collectPayment);
        Future<Integer> thread2 = executor.submit(MasterCardService::sendAnalytics);
        while (!thread.isDone() || !thread2.isDone()) {
            try {
                Thread.sleep(SLEEP_WAIT);
            } catch (InterruptedException e) {
                log.info("Interrupted");
            }
            System.out.println("Waiting for thread to finish");
        }
        try {
            System.out.println("Analytic send: " + thread2.get());
            System.out.println("Payment sent: " + thread.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
