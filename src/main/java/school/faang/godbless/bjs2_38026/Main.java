package school.faang.godbless.bjs2_38026;

public class Main {
    public static void main(String[] args) {
        AppWithPayments appWithPayments = AppWithPayments.getInstance();
        try {
            appWithPayments.doAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Main thread interrupted");
        }
    }
}
