package faang.school.godbless.workInMicrosoft;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++ ) {
            System.out.println("Message № - " + (i + 1) + " was sent!");
        }
    }
}
