package school.faang.sprint_4.task_bjs249894;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class MasterCardService {
    public static final int COLLECTED_PAYMENT = 10000;
    public static final int SENT_ANALYTICS = 1000;

    public static int collectPayment() {
        try {
            Thread.sleep(COLLECTED_PAYMENT);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        return COLLECTED_PAYMENT;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(SENT_ANALYTICS);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        return SENT_ANALYTICS;
    }
}
