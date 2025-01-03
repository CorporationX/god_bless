package school.faang.bjs249930;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futurePayment = executorService.submit(() -> collectPayment());
        CompletableFuture<Integer> futureAnalytic = CompletableFuture.supplyAsync(() -> sendAnalytics());

        try {

            Integer resultAnalytic = futureAnalytic.get();
            log.info("Analytics sent: {}", resultAnalytic);

            Integer resultPayment = futurePayment.get();
            log.info("Payment complete: {}", resultPayment);

        } catch (Exception e) {
            log.error("Execution error in doAll method");

        } finally {
            executorService.shutdownNow();
        }
    }
}