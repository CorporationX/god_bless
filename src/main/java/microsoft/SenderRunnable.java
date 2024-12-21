package microsoft;

public class SenderRunnable implements Runnable {
    private final int startindex;
    private final int endindex;

    public SenderRunnable(int startindex, int endindex) {
        this.startindex = startindex;
        this.endindex = endindex;
    }

    @Override
    public void run() {
        for (int i = startindex; i < endindex; i++) {
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
