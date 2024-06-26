package faang.school.godbless.Asynchronicity;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(5000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalystics() {
        try {
            Thread.sleep(1000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
