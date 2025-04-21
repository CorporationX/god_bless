package work.at.microsoft;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Your message no: %d has ben successfully sent!%n", i);

            if (i == endIndex) {
                System.out.printf("All messages from thread %s has ben successfully sent!%n",
                        Thread.currentThread().getName());
            }
        }
    }
}
