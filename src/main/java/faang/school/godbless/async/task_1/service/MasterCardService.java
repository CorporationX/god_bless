package faang.school.godbless.async.task_1.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
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
        Future<Integer> collectedPayment = EXECUTOR.submit(this::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics, EXECUTOR);
        futureAnalytics.join();
        try {
            System.out.println(futureAnalytics.get());
            int collectedPaymentResult = collectedPayment.get();
            System.out.println(collectedPaymentResult);
        } catch (ExecutionException | InterruptedException e) {
           log.error(e.getMessage());
        }
        EXECUTOR.shutdown();
    }

}
