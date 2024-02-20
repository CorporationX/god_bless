package faang.school.godbless.microsoft;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.printf("Email from %d to %d are successfully sent! \n", startIndex, endIndex);
    }
}
