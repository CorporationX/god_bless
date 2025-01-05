package school.faang.sprint4.task_50034;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    public int collectPayment() {

        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {

        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentFuture = executorService.submit(this::collectPayment);

        CompletableFuture.supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(result -> System.out.printf("Analytics has been sent:%d\n", result));

        try {
            int paymentResult = collectPaymentFuture.get();
            System.out.printf("Payment has been collected:%d\n", paymentResult);
        } catch (InterruptedException e) {
            log.error("Collect payment task has been interrupted, e: {}", e.toString());
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log.error("There was an exception during execution of collect payment, e: {}", e.toString());
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
