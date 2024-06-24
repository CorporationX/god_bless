package faang.school.godbless.async_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class MasterCardService {
    private final int COLLECT_PAYMENT_TAKING_TIME = 10_000;
    private final int SEND_ANALYTICS_TAKING_TIME = 1_000;
    private final int DATA_NUMBER_UPPER_BOUND = 10_000;

    public int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_TAKING_TIME);
            return ThreadLocalRandom.current().nextInt(DATA_NUMBER_UPPER_BOUND);
        } catch (InterruptedException e) {
            throw new RuntimeException("Caught an InterruptedException during collectingPayment: " + e.getMessage());
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_TAKING_TIME);
            return ThreadLocalRandom.current().nextInt(DATA_NUMBER_UPPER_BOUND);
        } catch (InterruptedException e) {
            throw new RuntimeException("Caught an InterruptedException during sendingAnalytics: " + e.getMessage());
        }
    }
}
