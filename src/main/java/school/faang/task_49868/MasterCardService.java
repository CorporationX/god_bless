package school.faang.task_49868;


public class MasterCardService {
    static int collectPayment() {
        final int COLLECT_PAYMENT = 10000;
        try {
            Thread.sleep(COLLECT_PAYMENT);
            return COLLECT_PAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        final int SEND_ANALYTICS = 1000;
        try {
            Thread.sleep(SEND_ANALYTICS);
            return SEND_ANALYTICS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
