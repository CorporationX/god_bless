package school.faang.bjs49937;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    public static final int N_THREADS = 2;
    public static final long WAIT_TIME = 2000;

    public void doAll() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(N_THREADS);

        Future<Integer> paymentFuture = service.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics)
                .thenAccept((res) -> log.info("Analysis: {}", res));

        while (!paymentFuture.isDone()) {
            Thread.sleep(WAIT_TIME);
        }
        log.info("Total payment {}", paymentFuture.get());

        service.shutdown();
        try {
            if (!service.awaitTermination(WAIT_TIME, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Error while collecting payment");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Error while sending analytics");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
