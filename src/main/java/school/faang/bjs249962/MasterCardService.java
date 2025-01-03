package school.faang.bjs249962;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    public static final int TEN_SECONDS = 10_000;
    public static final int ONE_SECOND = 1_000;

    private int collectPayment() {
        try {
            log.info("Process payment started...");
            Thread.sleep(TEN_SECONDS);
            log.info("Process payment ended!");
            return TEN_SECONDS;
        } catch (InterruptedException e) {
            log.error("Error occurred while processing payment", e);
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            log.info("Send analytics started...");
            Thread.sleep(ONE_SECOND);
            log.info("Send analytics ended");
            return ONE_SECOND;
        } catch (InterruptedException e) {
            log.error("Error occurred while sending analytics", e);
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public void doAll() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Integer> payment = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        int resultAnalytics = payment.get();
        System.out.println("Аналитика отправлена: " + resultAnalytics);
        int resultPayment = analytics.get();
        System.out.println("Платеж выполнен: " + resultPayment);
    }
}
