package school.faang.BJS2_61958;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MasterCardService {

    private static int collectPayment() {
        return universalMethod(ConstOfMasterCard.TEN_SECONDS_IN_MS, 5_000);
    }

    private static int sendAnalytics() {
        return universalMethod(ConstOfMasterCard.ONE_SECOND_IN_MS, 17_000);
    }

    private static int universalMethod(int oneSecondInMs, int x) {
        try {
            Thread.sleep(oneSecondInMs);
            return x;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(ConstOfMasterCard.INTERRUPTED_EXCEPTION, e);
            return ConstOfMasterCard.ERROR_VALUE;
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(ConstOfMasterCard.THREADS_COUNT);
        CompletableFuture.supplyAsync(MasterCardService::collectPayment, executor)
                .thenAccept(s -> applyLogic(s, ConstOfMasterCard.PAYMENT_COMPLETED));
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                .thenAccept(s -> applyLogic(s, ConstOfMasterCard.ANALYSIS_SEND));
        executor.shutdown();
    }

    private static void applyLogic(Integer s, String appliedLogic) {
        if (s == ConstOfMasterCard.ERROR_VALUE) {
            log.info(ConstOfMasterCard.EXCEPTION_MESSAGE);
        } else {
            log.info(appliedLogic, s);
        }
    }

}
