package faang.school.godbless.sprint2.asyncFuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class MasterCardService {

    @SneakyThrows
    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        log.info("Analytics {}", analyticsFuture.join());
        log.info("Payment {}", paymentFuture.get(30, TimeUnit.SECONDS));
        executor.shutdown();
    }

    @SneakyThrows
    private int collectPayment() {
        Thread.sleep(1000);
        return 1000;
    }

    @SneakyThrows
    private int sendAnalytics() {
        Thread.sleep(2000);
        return 2000;
    }
}
