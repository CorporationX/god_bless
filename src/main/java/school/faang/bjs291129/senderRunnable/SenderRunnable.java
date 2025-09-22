package school.faang.bjs291129.senderRunnable;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println("Sending emails from index " + startIndex + " to " + endIndex
            + " in thread " + Thread.currentThread().getName() + "...");
    }
}
