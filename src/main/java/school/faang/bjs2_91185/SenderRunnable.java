package school.faang.bjs2_91185;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо %s отправлено потоком %s%n",
                    i, Thread.currentThread().getName());
        }
    }
}