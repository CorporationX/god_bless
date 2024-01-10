package faang.school.godbless.multithreading_async.asynchrony_and_the_future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(5000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(3000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
