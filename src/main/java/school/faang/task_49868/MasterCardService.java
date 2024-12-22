package school.faang.task_49868;


public class MasterCardService {
    static int collectPayment() {
        final int COLLECTPAYMENT = 10000;
        try {
            Thread.sleep(COLLECTPAYMENT);
            return COLLECTPAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        final int SENDANALYTICS = 1000;
        try {
            Thread.sleep(SENDANALYTICS);
            return SENDANALYTICS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
