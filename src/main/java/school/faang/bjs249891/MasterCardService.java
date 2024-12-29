package school.faang.bjs249891;

public class MasterCardService {

    private static final int PAYMENT_COUNT = 10_000;
    private static final int ANALYTICS_COUNT = 10_000;
    private static final int INTERRUPTED_RESULT = -1;

    public static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_COUNT);
            return PAYMENT_COUNT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_COUNT);
            return ANALYTICS_COUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted: " + e.getMessage());
            return INTERRUPTED_RESULT;
        }
    }

}
