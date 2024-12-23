package school.faang.task_49867;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_SLEEP_DURATION = 1000;
    private static final int ANALYTICS_SLEEP_DURATION = 10000;

    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_SLEEP_DURATION);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return 1000;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_SLEEP_DURATION);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return 10000;
    }

}
