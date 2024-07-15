package faang.school.godbless.future.firstTask;

public class MasterCardService {
    public static final int SMALL_SLEEP_TIME = 3_000;
    public static final int BIG_SLEEP_TIME = 10_000;
    public static int collectPayment() {
        try {
            Thread.sleep(BIG_SLEEP_TIME);
            return BIG_SLEEP_TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalystics() {
        try {
            Thread.sleep(SMALL_SLEEP_TIME);
            return SMALL_SLEEP_TIME;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
