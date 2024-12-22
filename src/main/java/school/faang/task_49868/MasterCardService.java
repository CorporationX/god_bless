package school.faang.task_49868;


public class MasterCardService {
    static int collectPayment() {
        final int COLLECT = 10000;
        try {
            Thread.sleep(COLLECT);
            return COLLECT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        final int SEND = 1000;
        try {
            Thread.sleep(SEND);
            return SEND;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
