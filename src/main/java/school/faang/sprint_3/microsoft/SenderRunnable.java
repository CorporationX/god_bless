package school.faang.sprint_3.microsoft;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = endIndex; i > startIndex; i--) {
            System.out.println(Thread.currentThread().getName() + " отправил письмо " + i);
        }
    }
}
