package multithreading.microsoft;

public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.printf("A stack of letters numbered %s to %s was processed\n", startIndex, endIndex);
    }
}
