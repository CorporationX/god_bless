package school.faang.task_49867;

public class MasterCardService {
    private static final int PAYMENT_SLEEP_DURATION = 1000;
    private static final int ANALYTICS_SLEEP_DURATION = 10000;
    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_SLEEP_DURATION);
            return 1000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_SLEEP_DURATION);
            return 10000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
