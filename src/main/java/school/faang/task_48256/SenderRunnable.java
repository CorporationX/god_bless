package school.faang.task_48256;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        try {
            int i = startIndex;
            while (i <= endIndex) {
                System.out.println(i + " the message sent" + " : " + Thread.currentThread().getName());
                ++i;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in thread");
        }
    }
}