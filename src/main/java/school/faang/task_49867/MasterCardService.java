package school.faang.task_49867;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
