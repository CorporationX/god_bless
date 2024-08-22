package faang.school.godbless;

public class SenderRunnable implements Runnable{

    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {

            System.out.printf("Thread %s: Sending email %d\n",
                    Thread.currentThread().getName(), i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted while sending email.");
            }
        }
        System.out.printf("Thread %s: Finished sending emails from %d to %d\n",
                Thread.currentThread().getName(), startIndex, endIndex);

    }
}
