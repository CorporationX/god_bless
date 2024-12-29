package school.faang.async_future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_VALUE = 10_000;
    private static final int ANALYTICS_VALUE = 1_000;

    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_VALUE);
        } catch (InterruptedException e) {
            log.error("Thread running was interrupted {}", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        return PAYMENT_VALUE;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_VALUE);
        } catch (InterruptedException e) {
            log.error("Thread running was interrupted {}", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        return ANALYTICS_VALUE;
    }
}
