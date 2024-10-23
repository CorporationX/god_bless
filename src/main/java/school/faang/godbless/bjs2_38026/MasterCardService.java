package school.faang.godbless.bjs2_38026;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_TIME = 10000;
    private static final int PAYMENT_MIN_VALUE = 100;
    private static final int PAYMENT_MAX_VALUE = 1000000;
    private static final int SEND_ANALYTICS_TIME = 1000;

    public int collectPayment() {
        try {
            log.info("Thread {} is collecting a payment", Thread.currentThread().getName());
            Thread.sleep(PAYMENT_TIME);
        } catch (InterruptedException e) {
            log.error("Thread interrupted when collecting payment");
            Thread.currentThread().interrupt();
        }
        return ThreadLocalRandom.current().nextInt(PAYMENT_MIN_VALUE, PAYMENT_MAX_VALUE + 1);
    }

    public void sendAnalytics(String analytics) {
        try {
            log.info("Thread {} is sending analytics {}", Thread.currentThread().getName(), analytics);
            Thread.sleep(SEND_ANALYTICS_TIME);
        } catch (InterruptedException e) {
            log.error("Thread interrupted when sending analytics");
            Thread.currentThread().interrupt();
        }
    }
}
