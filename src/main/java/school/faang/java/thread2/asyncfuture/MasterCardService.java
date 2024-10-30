package school.faang.java.thread2.asyncfuture;

public class MasterCardService {

    public int collectPayment() {
        workingTime(10000);
        return 10000;
    }

    public int sendAnalytics() {
        workingTime(1000);
        return 1000;
    }

    public void workingTime(int workingTime) {
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("EAF001 - InterruptedException");
        }
    }
}