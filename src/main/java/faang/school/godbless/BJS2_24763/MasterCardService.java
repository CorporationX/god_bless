package faang.school.godbless.BJS2_24763;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MasterCardService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void doAll() {
        Future<Integer> future = executorService.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(System.out::println)
                .join();

        try {
            int paymentResult = future.get(2, TimeUnit.MINUTES);
            System.out.println(paymentResult);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
