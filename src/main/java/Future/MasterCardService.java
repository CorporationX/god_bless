package Future;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
            return -1;
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
            return -1;
        }
    }
}