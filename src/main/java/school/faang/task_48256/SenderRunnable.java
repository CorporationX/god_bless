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
                System.out.println("Sending the message " + i);
                ++i;
            }
        } catch (RuntimeException e) {
            System.out.println("Something went wrong");
        }
    }
}