package faang.school.godbless.asynch1;

public class MasterCardService {

    private static final int TIME_TO_COLLECT_PAYMENT = 10_000;
    private static final int TIME_TO_SEND_ANALYTICS = 1_000;

    public int collectPayment() {
        return waitAndReturnWaitingTime(TIME_TO_COLLECT_PAYMENT);
    }

    public int sendAnalytics() {
        return waitAndReturnWaitingTime(TIME_TO_SEND_ANALYTICS);
    }

    private static int waitAndReturnWaitingTime(int time) {
        try {
            Thread.sleep(time);
            return time;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
