package school.faang.bjs249906;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {

    public static final int PAYMENT_NUMBER = 3000;
    public static final int ANALYTICS_NUMBER = 500;

    public static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_NUMBER);
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted", Thread.currentThread().getName());
        }
        return PAYMENT_NUMBER;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_NUMBER);
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted", Thread.currentThread().getName());
        }
        return ANALYTICS_NUMBER;
    }
}