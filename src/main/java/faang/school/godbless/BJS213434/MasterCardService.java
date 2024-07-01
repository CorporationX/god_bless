package faang.school.godbless.BJS213434;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during payment collection", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during analytics sending", e);
        }
    }
}
