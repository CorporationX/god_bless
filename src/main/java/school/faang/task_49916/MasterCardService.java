package school.faang.task_49916;

public class MasterCardService {
    private static final int COLLECTING_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;

    public int collectPayment() throws InterruptedException {
        Thread.sleep(COLLECTING_TIME);
        return COLLECTING_TIME;
    }

    public int sendAnalytics() throws InterruptedException {
        Thread.sleep(ANALYTICS_TIME);
        return ANALYTICS_TIME;
    }
}
