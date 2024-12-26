package school.faang.bjs_49883;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_DURATION = 10000;
    private static final int ANALYTICS_DURATION = 1000;

    public int collectPayment() {
        log.info("Payment started");

        try {
            Thread.sleep(PAYMENT_DURATION);
        } catch (InterruptedException e) {
            log.error("Payment interrupted", e);
        }

        log.info("Payment completed");
        return PAYMENT_DURATION;
    }

    public int sendAnalytics() {
        log.info("Analytics started");

        try {
            Thread.sleep(ANALYTICS_DURATION);
        } catch (InterruptedException e) {
            log.error("Analytics interrupted", e);
        }

        log.info("Analytics completed");
        return ANALYTICS_DURATION;
    }
}
