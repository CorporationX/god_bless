package school.faang.bks2_82429;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int COUNT_THREAD = 4;
    private static final int PAY = 5_000;
    private static final int ANALYTIC = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAY;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTIC;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        try {
            Future<Integer> futurePayment = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
            int analyticsResult = futureAnalytics.get();
            log.info("Send analytics {}", analyticsResult);
            int paymentResult = futurePayment.get();
            log.info("Payment done {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }

    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
