package microsoft;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startindex, int endindex) {
        this.startIndex = startindex;
        this.endIndex = endindex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено: " + (i + 1));
        }
    }
}
