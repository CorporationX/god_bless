package bjs2_91067;

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
            // Имитация отправки письма
            System.out.println(Thread.currentThread().getName() + " отправил письмо №" + i);
        }
    }
}