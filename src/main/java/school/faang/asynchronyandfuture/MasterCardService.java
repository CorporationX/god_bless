package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    private String collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return "Оплата произведена успешно!";
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private String sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return "Аналитика отправлена успешно!";
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        Future<String> payment = executor.submit(this::collectPayment);
        CompletableFuture<String> sendAn = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        System.out.println(sendAn.join());

        try {
            System.out.println(payment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            throw new RuntimeException();
        }
    }
}
