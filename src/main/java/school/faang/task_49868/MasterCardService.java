package school.faang.task_49868;


public class MasterCardService {
    static int collectPayment() {
        final int collectPaymentConst = 10000;
        try {
            Thread.sleep(collectPaymentConst);
            return collectPaymentConst;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        final int sendAnalyticsConst = 1000;
        try {
            Thread.sleep(sendAnalyticsConst);
            return sendAnalyticsConst;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
