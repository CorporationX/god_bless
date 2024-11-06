package school.faang.java.thread2.threemags;

public class Timeout {
    public final static int DIF = 10;

    public Timeout(int workingTime) {
        try {
            Thread.sleep((long) workingTime * DIF);
            System.out.printf("\nWorking time %d", workingTime * DIF);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("EUR001 - InterruptedException");
        }
    }
}