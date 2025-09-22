package school.faang.multithreading.async.bjs2_92526;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10;
    private static final int ONE_SECOND_IN_MS = 1;


    static int collectPayment() {
        try {
            TimeUnit.SECONDS.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            TimeUnit.SECONDS.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analiticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics());

        Integer analiticsResult = analiticsFuture.join();
        log.info("Аналитика отправлена: " + analiticsResult);

        Integer paymentResult = paymentFuture.get();
        log.info("Оплата прошла успешно: " + paymentResult);

        paymentFuture.cancel(true);
        analiticsFuture.cancel(true);
        executor.shutdown();
    }
}
