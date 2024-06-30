package faang.school.godbless;


public class MasterCardService {
    private static final int THREAD_SLEEP_TIMEOUT = 10000;
    private static final int MULTIPLEXER = 10;

    public int collectPayment() {
        try {
            Thread.sleep(THREAD_SLEEP_TIMEOUT);
            return THREAD_SLEEP_TIMEOUT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread is interrupted", e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(THREAD_SLEEP_TIMEOUT/MULTIPLEXER);
            return THREAD_SLEEP_TIMEOUT/MULTIPLEXER;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread is interrupted", e);
        }
    }
}
