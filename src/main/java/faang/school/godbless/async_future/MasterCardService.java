package faang.school.godbless.async_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class MasterCardService {
    private final int COLLECT_PAYMENT_TAKING_TIME = 10_000;
    private final int SEND_ANALYTICS_TAKING_TIME = 1_000;

    public int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_TAKING_TIME);
            return ThreadLocalRandom.current().nextInt(1000, 10000);
        } catch (InterruptedException e) {
            log.warn("Caught an exception during collectingPayment: " + e.getMessage());
            throw new RuntimeException("Caught an InterruptedException during collectingPayment: " + e.getMessage());
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_TAKING_TIME);
            return ThreadLocalRandom.current().nextInt(1000, 10000);
        } catch (InterruptedException e) {
            log.warn("Caught an exception during collectingPayment: " + e.getMessage());
            throw new RuntimeException("Caught an InterruptedException during collectingPayment: " + e.getMessage());
        }
    }
}
