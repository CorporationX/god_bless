package school.faang.bjs49937;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static final int N_THREADS = 2;

    public void doAll() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(N_THREADS);

        Future<Integer> paymentFuture = service.submit(MasterCardService::collectPayment);
        var analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        log.info("Total payment {}", paymentFuture.get());
        analytics.thenAccept((res) -> log.info("Analytics: {}", res));

        service.shutdown();
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
            Thread.sleep(2_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Error while sending analytics");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
