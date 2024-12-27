package school.faang.task_48741;

public class SenderRunnable implements Runnable {
    private int startindex;
    private int endindex;

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
